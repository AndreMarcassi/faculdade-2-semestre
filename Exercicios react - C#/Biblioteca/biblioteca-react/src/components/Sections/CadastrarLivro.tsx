import { useEffect, useState } from "react";
import { Livro } from "../../models/Livro";


function CadastrarLivro() {
    const [livros, setLivros] = useState<Livro[]>([]);

    const [titulo, setTitulo] = useState("");
    const [autor, setAutor] = useState("");
    const [editora, setEditora] = useState("");
    const [quantidade, setQuantidade] = useState(0);
    const [categoriaId, setCategoriaId] = useState(""); 
    //const [capaFile, setCapaFile] = useState<File | null>(null);

    useEffect(() => {
        carregarLivros(); 
    }, []);
  
    function carregarLivros() {
        //FETCH ou AXIOS
        fetch("http://localhost:5098/api/livro/listar")
        .then((resposta) => resposta.json()) 
        .then((livros: Livro[]) => {                   
            setLivros(livros);
        });                              
    }

    function cadastrarLivro(e: any) {
        e.preventDefault();
    
        const livro : Partial<Livro> = {
            editora : editora,
            titulo : titulo,
            autor : autor,
            quantidade : quantidade,
            categoriaId : categoriaId
        };
      
        //FETCH ou AXIOS
        fetch("http://localhost:5098/api/livro/cadastrar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(livro),
        })
            .then((resposta) => resposta.json())
            .then((livro : Livro) => {});

    }
    
  
    return (

        <form className="flex" action="" method="post" style={{flexWrap: 'wrap'}} onSubmit={cadastrarLivro}>

            <input className="form-input" type="text" placeholder="titulo" onChange={(e: any) => setTitulo(e.target.value)} required/>

            <input className="form-input" type="text" placeholder="autor" onChange={(e: any) => setAutor(e.target.value)}/>

            <input className="form-input" type="text" placeholder="editora" onChange={(e: any) => setEditora(e.target.value)} required/>

            <input className="form-input" type="number" placeholder="quantidade" onChange={(e: any) => setQuantidade(e.target.value)} required/>

            <input className="form-input" type="text" placeholder="ID da categoria" onChange={(e: any) => setCategoriaId(e.target.value)} required/>

            {/* <div className="form-input form-file">

                <span className="form-file-label">Escolher arquivo</span>

                <input type="file" accept="image/*" onChange={(e) => setCapaFile(e.target.files ? e.target.files[0] : null)}/>

            </div> */}

            <input className="form-input" type="submit" value="Confirmar"/>

        </form>
        
    );

}

export default CadastrarLivro;