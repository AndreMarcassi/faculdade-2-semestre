import axios from "axios";
import { Usuario } from "../../models/Usuario";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function DeletarUsuario() {
    const [nomeUsuario, setNomeUsuario] = useState("");
    const [usuario, setUsuario] = useState<Usuario[]>([]);

    useEffect(() => {
        carregarUsuarios();
    }, []);

    function carregarUsuarios() {
        //FETCH ou AXIOS
        fetch("http://localhost:5098/api/usuario/listar")
            .then((resposta) => resposta.json())
            .then((usuarios: Usuario[]) => {
                console.table(usuarios);
                setUsuario(usuarios);
            });
    }

    function deletar(e: React.FormEvent<HTMLFormElement>) {

        fetch(`http://localhost:5098/api/usuario/deletar/${nomeUsuario}`, {
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
        
            <input className="form-input" type="text" placeholder="Digite o nome do Usuario" onChange={(e: any) => setNomeUsuario(e.target.value)} required/>

            <input className="form-input" type="submit" value="Confirmar"></input>

        </form>

    );
}

export default DeletarUsuario;