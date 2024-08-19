import { Categoria } from "../../models/Categoria";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function ListarCategoria() {
    const [categorias, setCategorias] = useState<Categoria[]>([]);

    useEffect(() => {
        carregarProdutos();
    }, []);

    function carregarProdutos() {
        //FETCH ou AXIOS
        fetch("http://localhost:5098/api/categoria/listar")
            .then((resposta) => resposta.json())
            .then((categorias: Categoria[]) => {
                console.table(categorias);
                setCategorias(categorias);
            });
    }


    return (
        <div>

            {categorias.map((categoria) => (
                <ul>

                    <li> ID: {categoria.id} </li>
                    <li> Categoria: {categoria.nomeCategoria} </li>
                    <br />

                </ul>
            ))}
            
        </div>
    );
}

export default ListarCategoria;