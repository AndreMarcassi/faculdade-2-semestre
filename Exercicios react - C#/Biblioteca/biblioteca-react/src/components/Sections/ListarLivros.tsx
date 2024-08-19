import { Livro } from "../../models/Livro";
import { useEffect, useState } from "react";

function ListarLivros() {
    const [livros, setLivros] = useState<Livro[]>([]);

    useEffect(() => {
        carregarLivros();
    }, []);

    function carregarLivros() {
        // FETCH ou AXIOS
        fetch("http://localhost:5098/api/livro/listar")
            .then((resposta) => resposta.json())
            .then((livros: Livro[]) => {
                console.table(livros);
                setLivros(livros);
            })
    }

    return (

        <div>
            
            {livros.map((livro) => (

                <ul key={livro.id}>

                    <li> ID: {livro.id} </li>
                    <li> Titilo: {livro.titulo} </li>
                    <br />

                </ul>

            ))}

        </div>

    );

}

export default ListarLivros;
