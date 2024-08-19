import axios from "axios";
import { Categoria } from "../../models/Categoria";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function DeletarCategoria() {
    const [nomeCategoria, setNomeCategoria] = useState("");
    const [categorias, setCategorias] = useState<Categoria[]>([]);

    useEffect(() => {
        carregarCategorias();
    }, []);

    function carregarCategorias() {
        //FETCH ou AXIOS
        fetch("http://localhost:5098/api/categoria/listar")
            .then((resposta) => resposta.json())
            .then((categorias: Categoria[]) => {
                console.table(categorias);
                setCategorias(categorias);
            });
    }

    function deletar(e: React.FormEvent<HTMLFormElement>) {

        fetch(`http://localhost:5098/api/categoria/deletar/${nomeCategoria}`, {
                method: "DELETE",
                headers: {
                  "Content-Type": "application/json",
                },
              })
                .then((resposta) => resposta.json())

        e.preventDefault();

    }

    return (

        <form className="flex" style={{flexWrap: 'wrap'}} onSubmit={deletar}>
        
            <input className="form-input" type="text" placeholder="Digite o nome da categoria" onChange={(e: any) => setNomeCategoria(e.target.value)} required/>

            <input className="form-input" type="submit" value="Confirmar"></input>

        </form>

    );
}

export default DeletarCategoria;