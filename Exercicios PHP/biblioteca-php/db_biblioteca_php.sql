-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10/06/2024 às 15:15
-- Versão do servidor: 8.1.0
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_biblioteca_php`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categorias`
--

CREATE TABLE `categorias` (
  `PK_Id_categoria` int NOT NULL,
  `categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `categorias`
--

INSERT INTO `categorias` (`PK_Id_categoria`, `categoria`) VALUES
(1, 'Ficção Científica'),
(2, 'Romance'),
(3, 'Fantasia'),
(4, 'Terror'),
(5, 'Mistério'),
(6, 'Suspense'),
(9, 'Autobiografia'),
(10, 'Ficção Histórica'),
(11, 'Literatura Clássica'),
(12, 'Poesia'),
(14, 'Comédia'),
(15, 'Filosofia'),
(16, 'Psicologia'),
(17, 'Autoajuda'),
(18, 'Espiritualidade'),
(20, 'Ciência'),
(21, 'Tecnologia');

-- --------------------------------------------------------

--
-- Estrutura para tabela `ligacao`
--

CREATE TABLE `ligacao` (
  `PK_Id_licacao` int NOT NULL,
  `FK_id_locacao` int NOT NULL,
  `FK_id_livro` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `livros`
--

CREATE TABLE `livros` (
  `PK_Id_livro` int NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) NOT NULL,
  `editora` varchar(255) NOT NULL,
  `quantidade` int NOT NULL,
  `capa` varchar(255) NOT NULL,
  `FK_id_categoria` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `livros`
--

INSERT INTO `livros` (`PK_Id_livro`, `titulo`, `autor`, `editora`, `quantidade`, `capa`, `FK_id_categoria`) VALUES
(11, 'A Guerra dos Tronos : As Crônicas de Gelo e Fogo, volume 1', 'George R. R. Martin', 'suma', 12, './src/img/A_Guerra_dos_Tronos___As_Cr__nicas_de_Gelo_e_Fogo__volume_1.png', 3),
(12, 'A fúria dos reis: As Crônicas de Gelo e Fogo, volume 2', 'George R. R. Martin', 'suma', 12, './src/img/A_f__ria_dos_reis__As_Cr__nicas_de_Gelo_e_Fogo__volume_2.png', 3),
(13, 'A tormenta de espadas: As Crônicas de Gelo e Fogo, volume 3', 'George R. R. Martin', 'suma', 12, './src/img/A_tormenta_de_espadas__As_Cr__nicas_de_Gelo_e_Fogo__volume_3.png', 3),
(14, 'O Festim dos Corvos: As Crônicas de Gelo e Fogo, volume 4', 'George R. R. Martin', 'suma', 12, './src/img/O_Festim_dos_Corvos__As_Cr__nicas_de_Gelo_e_Fogo__volume_4.png', 3),
(15, 'A dança dos dragões: 5', 'George R. R. Martin', 'suma', 12, './src/img/A_dan__a_dos_drag__es__5.png', 3),
(16, 'Harry Potter e a Pedra Filosofal: 1', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_a_Pedra_Filosofal__1.png', 3),
(17, 'Harry Potter e a Câmara Secreta: 2', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_a_C__mara_Secreta__2.png', 3),
(18, 'Harry Potter e o Prisioneiro de Azkaban: 3', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_o_Prisioneiro_de_Azkaban__3.png', 3),
(19, 'Harry Potter e o Cálice de Fogo: 4', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_o_C__lice_de_Fogo__4.png', 3),
(20, 'Harry Potter e a Ordem da Fênix: 5 ', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_a_Ordem_da_F__nix__5_.png', 3),
(21, 'Harry Potter e o Enigma do Príncipe: 6', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_o_Enigma_do_Pr__ncipe__6.png', 3),
(22, 'Harry Potter e as Relíquias da Morte: 7', ' J.K. Rowling', 'Rocco', 12, './src/img/Harry_Potter_e_as_Rel__quias_da_Morte__7.png', 3);

-- --------------------------------------------------------

--
-- Estrutura para tabela `locacao`
--

CREATE TABLE `locacao` (
  `Data_locacao` date NOT NULL,
  `Data_devolucao` date NOT NULL,
  `PK_id_locacao` int NOT NULL,
  `FK_id_usuario` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `nome` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `endereco` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cpf` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `senha` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PK_id_usuario` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`nome`, `telefone`, `email`, `endereco`, `cpf`, `senha`, `PK_id_usuario`) VALUES
('andre', '', '', '', '1234', '$2y$10$CSAKDso3bR31zjrN.c..wudFWcXxyutU2TuS78KbKCvhdHkn7pQ7a', 9),
('edson', '', '', '', '4545', '$2y$10$XNKodsa0SeS5MUso6j6JxehlxItk5w/i9yrYa38D2pJZrpAkEdSk6', 10),
('pedro', '', '', '', '789', '$2y$10$EfWUe2.y7vDsbm56oxGHiejMYOFXmlw3KwQnXqvNHaQsANRdXXBMO', 11),
('ADM', '', '', '', 'ADM', '$2y$10$5DkdituOnr6sKAGsnpEjeOfv3qH19yPDiKNbddahk4fIf.ZIJNoYa', 12);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`PK_Id_categoria`);

--
-- Índices de tabela `ligacao`
--
ALTER TABLE `ligacao`
  ADD PRIMARY KEY (`PK_Id_licacao`),
  ADD KEY `FK_id_livro` (`FK_id_livro`),
  ADD KEY `ligacao_ibfk_1` (`FK_id_locacao`);

--
-- Índices de tabela `livros`
--
ALTER TABLE `livros`
  ADD PRIMARY KEY (`PK_Id_livro`),
  ADD KEY `FK_id_categoria` (`FK_id_categoria`);

--
-- Índices de tabela `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`PK_id_locacao`),
  ADD KEY `FK_id_usuario` (`FK_id_usuario`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`PK_id_usuario`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categorias`
--
ALTER TABLE `categorias`
  MODIFY `PK_Id_categoria` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de tabela `ligacao`
--
ALTER TABLE `ligacao`
  MODIFY `PK_Id_licacao` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de tabela `livros`
--
ALTER TABLE `livros`
  MODIFY `PK_Id_livro` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de tabela `locacao`
--
ALTER TABLE `locacao`
  MODIFY `PK_id_locacao` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `PK_id_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `ligacao`
--
ALTER TABLE `ligacao`
  ADD CONSTRAINT `ligacao_ibfk_1` FOREIGN KEY (`FK_id_locacao`) REFERENCES `locacao` (`PK_id_locacao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ligacao_ibfk_2` FOREIGN KEY (`FK_id_livro`) REFERENCES `livros` (`PK_Id_livro`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Restrições para tabelas `livros`
--
ALTER TABLE `livros`
  ADD CONSTRAINT `livros_ibfk_1` FOREIGN KEY (`FK_id_categoria`) REFERENCES `categorias` (`PK_Id_categoria`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Restrições para tabelas `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `locacao_ibfk_1` FOREIGN KEY (`FK_id_usuario`) REFERENCES `usuarios` (`PK_id_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
