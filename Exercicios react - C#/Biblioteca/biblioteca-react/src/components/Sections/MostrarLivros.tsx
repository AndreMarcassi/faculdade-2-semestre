import { useEffect, useState } from "react";
import { Livro } from "../../models/Livro";
import './MostrarLivros.css';

function MostrarLivros() {

    const [livros, setLivros] = useState<Livro[]>([]);
    
    const [listaParaLocar, setListaParaLocar] = useState<string[]>(() => {
        const savedList = localStorage.getItem("listaParaLocar");
        return savedList ? JSON.parse(savedList) : [];
    });

    useEffect(() => {
        carregarLivros();
    }, []);

    useEffect(() => {
        localStorage.setItem("listaParaLocar", JSON.stringify(listaParaLocar));
        window.dispatchEvent(new Event('storage'));
    }, [listaParaLocar]);
    

    function carregarLivros() {
        
        fetch("http://localhost:5098/api/livro/listar")
            .then((resposta) => resposta.json())
            .then((livros: Livro[]) => {
                setLivros(livros.map(livro => ({
                    ...livro
                })));

            })
        
            .catch((error) => {
                console.error("Erro ao carregar livros:", error);
            });
    }

    function addLivro(livroId: string) {

        if (livros.find(livro => livro.id === livroId)) {

            setListaParaLocar(prevList => {
                
                if (!prevList.includes(livroId)) {
                    return [...prevList, livroId];
                }

                return prevList;

            });

        }

    }

    return (

        <section className="flex borda-teste" style={{ flexWrap: 'wrap', justifyContent: 'space-evenly' }}>

            {livros.map(livro => (

                <div className="livro" style={{ backgroundImage: `url(${livro.capa})` }} key={livro.id}>

                    <button className="locacao" type="button" onClick={() => addLivro(livro.id)}> locar </button>

                </div>

            ))}

        </section>

    );

}

export default MostrarLivros;