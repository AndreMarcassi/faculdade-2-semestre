import React, { useEffect, useState } from 'react';
import './ListaParaLocar.css';
import { Livro } from '../../models/Livro';

function ListaParaLocar() {

    const [livrosDetalhes, setLivrosDetalhes] = useState<Livro[]>([]);

    useEffect(() => {
        carregarLivros();

        window.addEventListener('storage', handleStorageChange);
    
        return () => {
            window.removeEventListener('storage', handleStorageChange);
        };

    }, []);
    
    function handleStorageChange(event: StorageEvent) {
        carregarLivros();
    }

    function carregarLivros() {
        
        const savedList = localStorage.getItem('listaParaLocar');
        const livroIds = savedList ? JSON.parse(savedList) : [];
        
        Promise.all(livroIds.map((id: string) => fetch(`http://localhost:5098/api/livro/listar/${id}`)
        .then(response => response.json())))
        .then(livrosDetalhes => { 
            setLivrosDetalhes(livrosDetalhes)})
        .catch(error => {console.error('Erro ao carregar detalhes dos livros:', error)}

        );

    }

    function removerLivro(id: string) {

        const updatedList = livrosDetalhes.filter(livro => livro.id !== id);

        setLivrosDetalhes(updatedList);

        const updatedIds = updatedList.map(livro => livro.id);
        localStorage.setItem('listaParaLocar', JSON.stringify(updatedIds));

    }

    function locarLivros() {
        const usuarioID = localStorage.getItem('usuarioID');
        const savedList = localStorage.getItem('listaParaLocar');
    
        if (!usuarioID || !savedList) {
            console.error('Usuário não está autenticado ou lista de locação não encontrada.');
            return;
        }
    
        fetch(`http://localhost:5098/api/locacao/efetuar/${usuarioID}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: savedList,
        })
        .then((resposta) => resposta.json())
        .then((data) => {
            console.log('Locação efetuada com sucesso:', data);
            setLivrosDetalhes([]);
            localStorage.removeItem('listaParaLocar');
        })
        .catch((error) => {
            console.error('Erro ao efetuar locação:', error);
        });
    }

    return (

        <div className="dropdown">

            <button className="butao-dropdown flex dropdown-toggle" type="button">LOCAÇÕES</button>

            <div className="dropdown-content" id="locacoes-list" style={{width: '200%'}}>

                {livrosDetalhes.map(livro => (
                
                    <div className="lista-locacao flex" key={livro.id}>

                        <div className="locacao-capa flex">
                            <img src={livro.capa} alt="Capa do livro"/>
                        </div>

                        <div className="locacao-titulo flex" style={{flexWrap: 'wrap' }}>

                            <h4 className="titulo"> {livro.titulo} </h4>

                            <button className="butao-remover" type="button" onClick={() => removerLivro(livro.id)}>Remover</button>

                        </div>

                    </div>

                ))}

                <button className="efetuar-locacao" type="button" style={{ textAlign: 'center' }} onClick={() => locarLivros()}>Efetuar locação</button>

            </div>

        </div>

    );

}

export default ListaParaLocar;