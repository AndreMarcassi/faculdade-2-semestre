import { useEffect, useState } from "react";
import { Categoria } from "../../models/Categoria";


function CadastrarCategoria() {
  const [nomeCategoria, setNomeCategoria] = useState("");
  const [categorias, setCategorias] = useState<Categoria[]>([]);

  useEffect(() => {
    carregarCategorias(); }, []);

  
  function carregarCategorias() {
    //FETCH ou AXIOS
    fetch("http://localhost:5098/api/categoria/listar")
      .then((resposta) => resposta.json()) 
      .then((categorias: Categoria[]) => {                   
        setCategorias(categorias);
      });                              
  }


  function cadastrarCategoria(e: any) {

    const categoria : Categoria = {
      nomeCategoria : nomeCategoria
    };

    //FETCH ou AXIOS
    fetch("http://localhost:5098/api/categoria/cadastrar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(categoria),
    })
      .then((resposta) => resposta.json())
      .then((categoria : Categoria) => {});

    e.preventDefault();

  }
  
  return (

    <form className="flex" style={{flexWrap: 'wrap'}} onSubmit={cadastrarCategoria}>
            
        <input className="form-input" type="text" placeholder="Digite o nome da categoria" 
        onChange={(e: any) => setNomeCategoria(e.target.value)} required/>

        <input className="form-input" type="submit" value="Confirmar"></input>

    </form>
    
  );
}

export default CadastrarCategoria;