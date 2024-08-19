using System.Net.Http.Json;
using System.Net.Mail;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Xml;
using Api.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using JsonSerializer = System.Text.Json.JsonSerializer;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddDbContext<AppDataContext>();

builder.Services.AddCors(options => 
    options.AddPolicy("Acesso Total", 
        configs => configs
            .AllowAnyOrigin()
            .AllowAnyHeader()
            .AllowAnyMethod())
);

var app = builder.Build();


// POST : http://localhost:5098/api/usuario/cadastrar
app.MapPost("/api/usuario/cadastrar",([FromBody] Usuario usuarios, [FromServices] AppDataContext ctx) =>{   
    ctx.Usuarios.AddRange(usuarios);
    ctx.SaveChanges();
    return Results.Created("", usuarios);
});

// POST : http://localhost:5098/api/usuario/verificar
app.MapPost("/api/usuario/verificar", ([FromBody] LoginRequest loginRequest, [FromServices] AppDataContext ctx) =>
{
    Usuario usuario = ctx.Usuarios.FirstOrDefault(e => e.Cpf == loginRequest.Cpf);

    if (usuario == null)
    {
        return Results.NotFound("Usuário não encontrado.");
    }

    if (usuario.Senha == loginRequest.Senha)
    {
        return Results.Ok(usuario);
    }

    return Results.Unauthorized();
});

// POST : http://localhost:5098/api/usuario/buscar/
app.MapGet("/api/usuario/buscar/{id}", ([FromRoute] Guid id, [FromServices] AppDataContext ctx) =>{
    Usuario? usuario = ctx.Usuarios.Find(id);

    if (usuario == null)
    {
        return Results.NotFound("Usuário não encontrado.");
    }

    return Results.Ok(usuario);
});

// DELETE : http://localhost:5098/api/usuario/deletar/
app.MapDelete("/api/usuario/deletar/{id}",([FromRoute] Guid id,[FromServices] AppDataContext ctx) =>{
    Usuario? usuario = ctx.Usuarios.Find(id);
    if (usuario == null) {
        return Results.NotFound("Usuário não encontrado.");
    }
    ctx.Usuarios.Remove(usuario);
    ctx.SaveChanges();
    return Results. Ok("Usuário deletado com sucesso!");
});

// PUT : http://localhost:5098/api/usuario/alterar/
app.MapPut("/api/usuario/alterar/{id}",([FromRoute] Guid id,[FromBody] Usuario usuarioAlterado,[FromServices] AppDataContext ctx) =>{
    Usuario? usuario = ctx.Usuarios.Find(id);
    if (usuario is null){
        return Results.NotFound("Usuário não encontrado!");
    }

    if (usuarioAlterado.Telefone != null) {
        usuario.Telefone = usuarioAlterado.Telefone;
    }
    
    if (usuarioAlterado.Email != null) {
        usuario.Email = usuarioAlterado.Email;
    }

    if (usuarioAlterado.Endereco != null) {
        usuario.Endereco = usuarioAlterado.Endereco;
    }

    if (usuarioAlterado.Senha != null) {
        usuario.Senha = usuarioAlterado.Senha;
    }

    ctx.Usuarios.Update(usuario);
    ctx.SaveChanges();
    return Results.Ok("Usuário alterado com sucesso!");
});

// GET : http://localhost:5098/api/usuario/listar
app.MapGet("/api/usuario/listar",([FromServices] AppDataContext ctx) =>{
    if (ctx.Usuarios.Any()){
        return Results.Ok(ctx.Usuarios.ToList());
    }
    return Results.NotFound("Tabela vazia!");
});

// POST : http://localhost:5098/api/livro/cadastrar
app.MapPost("/api/livro/cadastrar", async ([FromBody] LivroCreateModel model, [FromServices] AppDataContext ctx) =>{
    
    if (model == null){
        return Results.BadRequest("O modelo enviado está nulo.");
    }

    string fileName = null;

    if (model.CapaFile != null){

        var imagesFolderPath = Path.Combine(Directory.GetCurrentDirectory(), "imgs");

        if (!Directory.Exists(imagesFolderPath)){
            Directory.CreateDirectory(imagesFolderPath);
        }

        fileName = $"{Path.GetFileNameWithoutExtension(model.CapaFile.FileName)}_{Guid.NewGuid()}{Path.GetExtension(model.CapaFile.FileName)}";
        string filePath = Path.Combine(imagesFolderPath, fileName);

        using (var stream = new FileStream(filePath, FileMode.Create)){
            await model.CapaFile.CopyToAsync(stream);
        }
    }

    var livro = new Livro
    {
        Titulo = model.Titulo,
        Autor = model.Autor,
        Editora = model.Editora,
        Quantidade = model.Quantidade,
        CategoriaId = model.CategoriaId,
        CapaFilePath = fileName != null ? Path.Combine("images", fileName) : null
    };

    ctx.Livros.Add(livro);
    await ctx.SaveChangesAsync();
    return Results.Created("", livro);
});


// DELETE : http://localhost:5098/api/livro/deletar/
app.MapDelete("/api/livro/deletar/{id}",([FromRoute] Guid id,[FromServices] AppDataContext ctx) =>{
    Livro? livro = ctx.Livros.Find(id);
    if (livro == null) {
        return Results.NotFound("Livro não encontrado.");
    }
    ctx.Livros.Remove(livro);
    ctx.SaveChanges();
    return Results. Ok("Livro deletado com sucesso!");
});


// PUT : http://localhost:5098/api/livro/alterar/
app.MapPut("/api/livro/alterar/{id}",([FromRoute] Guid id,[FromBody] Livro livroAlterado,[FromServices] AppDataContext ctx) =>{
    Livro? livro = ctx.Livros.Find(id);
    if (livro is null){
        return Results.NotFound("Livro não encontrado!");
    }

    livro.Quantidade = livroAlterado.Quantidade; 

    ctx.Livros.Update(livro);
    ctx.SaveChanges();
    return Results.Ok("Livro alterado com sucesso!");
});


// GET : http://localhost:5098/api/livro/listar
app.MapGet("/api/livro/listar",([FromServices] AppDataContext ctx) =>{
    if (ctx.Livros.Any()){
        return Results.Ok(ctx.Livros.ToList());
    }
    return Results.NotFound("Tabela vazia!");
});


// GET : http://localhost:5098/api/livro/listar/
app.MapGet("/api/livro/listar/{id}", ([FromRoute] Guid id, [FromServices] AppDataContext ctx) => {

    Livro? livro = ctx.Livros.Find(id);

    if (livro is null){
        return Results.NotFound("Livro não encontrado!");
    }

    return Results.Ok(livro);

});

// POST : http://localhost:5098/api/categoria/cadastrar
app.MapPost("/api/categoria/cadastrar", ([FromBody] Categoria categorias, [FromServices] AppDataContext ctx) =>{
    ctx.Categorias.AddRange(categorias);
    ctx.SaveChanges();
    return Results.Created("", categorias);
});


// GET : http://localhost:5098/api/categoria/listar
app.MapGet("/api/categoria/listar",([FromServices] AppDataContext ctx) =>{
    if (ctx.Categorias.Any()){
        return Results.Ok(ctx.Categorias.ToList());
    }
    return Results.NotFound("Tabela vazia!");
});

// DELETE : http://localhost:5098/api/categoria/deletar/
app.MapDelete("/api/categoria/deletar/{NomeCategoria}",([FromRoute] String NomeCategoria,[FromServices] AppDataContext ctx) =>{

    Categoria? categoria = ctx.Categorias.FirstOrDefault(e => e.NomeCategoria == NomeCategoria);

    if (categoria == null) {
        return Results.NotFound("Categoria não encontrado.");
    }

    ctx.Categorias.Remove(categoria);
    ctx.SaveChanges();
    return Results. Ok("Categoria deletado com sucesso!");
});


// POST : http://localhost:5098/api/locacao/efetuar/
app.MapPost("/api/locacao/efetuar/{id}", ([FromRoute] Guid id, [FromBody] List<Guid> livroIds, [FromServices] AppDataContext ctx) => {
    
    Usuario usuario = ctx.Usuarios.Find(id);

    if (usuario == null) {
        return Results.BadRequest("Usuário não encontrado.");
    }

    if (livroIds == null || livroIds.Count == 0) {
        return Results.BadRequest("Nenhum livro foi especificado para locação.");
    }

    var locacoes = new List<Locacao>();

    foreach (Guid livroId in livroIds) {
        Livro livro = ctx.Livros.FirstOrDefault(l => l.Id == livroId);

        if (livro == null) {
            return Results.BadRequest($"Livro com id '{livroId}' não encontrado.");
        }

        if (livro.Quantidade <= 0) {
            return Results.BadRequest($"Livro com id '{livroId}' está esgotado.");
        }

        livro.Quantidade -= 1;

        var locacao = new Locacao {
            UsuarioId = id,
            DataEmprestimo = DateTime.UtcNow,
            Ligacoes = new List<Ligacao> {
                new Ligacao {
                    LivrosId = livroId
                }
            }
        };

        ctx.Locacoes.Add(locacao);
        locacoes.Add(locacao);
    }

    ctx.SaveChanges();

    var options = new JsonSerializerOptions {
        ReferenceHandler = ReferenceHandler.Preserve
    };

    string jsonString = System.Text.Json.JsonSerializer.Serialize(locacoes, options);

    return Results.Created("", jsonString);
});



// DELETE : http://localhost:5098/api/locacao/devolver/
app.MapDelete("/api/locacao/devolver/{id}", ([FromRoute] Guid id, [FromServices] AppDataContext ctx) =>{
    Locacao? locacao = ctx.Locacoes.Find(id);
    if (locacao is null) {
        return Results.NotFound("locação não encontrado.");
    }else{
        decimal multa = locacao.CalcularMulta();
        if (multa==0){
            ctx.Locacoes.Remove(locacao);
            ctx.SaveChanges();
            return Results.Ok("devolução efetuada!");
        }else{
            int dias = locacao.ClacularDia();
            ctx.Locacoes.Remove(locacao);
            ctx.SaveChanges();
            return Results.Ok("devolução efetuada com multa de R$" + multa + " referente aos " + dias + " dias");
        }
    }
});


// GET : http://localhost:5098/api/locacao/listar
app.MapGet("/api/locacao/listar/{id}", async ([FromRoute] Guid id, [FromServices] AppDataContext ctx) =>{
    var locacoes = await ctx.Locacoes
                            .Where(l => l.UsuarioId == id)
                            .Include(l => l.Ligacoes)
                            .ThenInclude(l => l.Livro)
                            .ToListAsync();

    if (locacoes.Any()){
        var resultado = locacoes.Select(l =>
        {
            return new
            {
                Id = l.Id,
                DataEmprestimo = l.DataEmprestimo,
                DataDevolucaoEsperada = l.DataDevolucaoEsperada,
                Livros = l.Ligacoes.Select(ll => new
                {
                    LivroId = ll.Livro.Id,
                    Titulo = ll.Livro.Titulo,
                    //Capa = ll.Livro.Capa,
                    Autor = ll.Livro.Autor,
                    Editora = ll.Livro.Editora
                }).ToList()
            };
        }).ToList();

        return Results.Ok(resultado);
    }
    
    return Results.NotFound($"Nenhuma locação encontrada para o usuário com ID {id}!");
});









app.UseCors("Acesso Total");

app.Run();