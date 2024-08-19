import { SetStateAction, useEffect, useState } from "react";
import './PaginaADM.css';
import ListarCategoria from "./ListarCategoria";
import DeletarCategoria from "./DeletarCategoria";
import CadastrarCategoria from "./CadastrarCategoria";
import DeletarUsuario from "./DeletarUsuario";
import AlterarUsuario from "./AlterarUsuario";
import ListarUsuario from "./ListarUsuario";
import ListarLivros from "./ListarLivros";
import CadastrarLivro from "./CadastrarLivro";
import DeletarLivro from "./DeletarLivro";

type FormType = 'cadastrarCategoria' | 'deletarCategoria' | 'listarCategorias' | 'alterarUsuario' | 'deletarUsuario' | 'cadastrarLivro' | 'deletarLivro' |'listarUsuarios' | 'listarLivros' | null;

function PaginaADM() {

    const [activeFormDiv55, setActiveFormDiv55] = useState<FormType | null>('alterarUsuario');
    const [activeFormDiv35, setActiveFormDiv35] = useState<FormType | null>('listarUsuarios');


    const handleButtonClickDiv55 = (form: FormType) => {
        setActiveFormDiv55(form === activeFormDiv55 ? null : form);
    };
      
    const handleButtonClickDiv35 = (form: FormType) => {
        setActiveFormDiv35(form === activeFormDiv35 ? null : form);
    };

    return (

        <section className="flex borda-teste" style={{ height: '558px', justifyContent: 'space-evenly', padding: '20px' }}>

            <div className="div-55">

                <div className="flex div-butao">
                    
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv55('alterarUsuario')}>Alterar Usuário</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv55('cadastrarLivro')}>Cadastrar Livro</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv55('cadastrarCategoria')}>Cadastrar Categoria</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv55('deletarUsuario')}>Deletar Usuário</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv55('deletarLivro')}>Deletar Livro</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv55('deletarCategoria')}>Deletar Categoria</button>

                </div>

                <div className="flex div-display" id="display-form">

                    {activeFormDiv55 === 'cadastrarCategoria' && <CadastrarCategoria />}
                    {activeFormDiv55 === 'deletarCategoria' && <DeletarCategoria />}

                    {activeFormDiv55 === 'cadastrarLivro' && <CadastrarLivro/>}
                    {activeFormDiv55 === 'deletarLivro' && <DeletarLivro/>}

                    {activeFormDiv55 === 'alterarUsuario' && <AlterarUsuario/>}
                    {activeFormDiv55 === 'deletarUsuario' && <DeletarUsuario/>}

                </div>

            </div>

            <div className="div-35 flex">

                <div className="flex div-butao">

                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv35('listarUsuarios')}>Listar Usuários</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv35('listarLivros')}>Listar Livros</button>
                    <button className="butao-adm" type="button" onClick={() => handleButtonClickDiv35('listarCategorias')}>Listar Categorias</button>

                </div>

                <div className="div-display lista" id="display-list">

                    {activeFormDiv35 === 'listarUsuarios' && <ListarUsuario/>}
                    {activeFormDiv35 === 'listarLivros' && <ListarLivros/>}
                    {activeFormDiv35 === 'listarCategorias' && <ListarCategoria />}

                </div>

            </div>

        </section>

    );

}
      
export default PaginaADM;


