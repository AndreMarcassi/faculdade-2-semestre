public class LivroCreateModel{
    public string Titulo { get; set; }
    public string Autor { get; set; }
    public string Editora { get; set; }
    public int Quantidade { get; set; }
    public Guid CategoriaId { get; set; }
    public IFormFile? CapaFile { get; set; }
}