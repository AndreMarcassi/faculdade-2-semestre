import {Routes, Route, Navigate } from 'react-router-dom';
import PaginaADM from './PaginaADM';
import ListarLocacoes from './ListarLocacoes';
import './section.css';
import MostrarLivros from './MostrarLivros';

function Section() {

  return (

    <Routes>

        <Route path="*" element={<MostrarLivros />} />
        <Route path="/pagina-adm" element={<PaginaADM />} />
        <Route path="/minhas-locacoes" element={<ListarLocacoes />} />

    </Routes>

  );

}

export default Section;