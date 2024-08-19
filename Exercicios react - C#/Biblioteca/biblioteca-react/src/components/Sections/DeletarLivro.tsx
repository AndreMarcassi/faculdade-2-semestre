import { Livro } from "../../models/Livro";
import { useEffect, useState } from "react";

function DeletarLivro() {
    const [livros, setLivros] = useState<Livro[]>([]);
    const [titulo, setTitulo] = useState("");

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
            });
    }

    function deletar(e: any) {

        fetch(`http://localhost:5098/api/livro/deletar/${titulo}`, {
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
        
            <input className="form-input" type="text" placeholder="Digite o titulo do livro" onChange={(e: any) => setTitulo(e.target.value)} required/>

            <input className="form-input" type="submit" value="Confirmar"></input>

        </form>

    );
}

export default DeletarLivro;