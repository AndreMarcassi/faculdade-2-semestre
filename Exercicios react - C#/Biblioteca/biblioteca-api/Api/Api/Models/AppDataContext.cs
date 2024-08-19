using Api.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;

public class AppDataContext: DbContext{

    public DbSet<Livro> Livros { get; set; }

    public DbSet<Usuario> Usuarios { get; set; }

    public DbSet<Categoria> Categorias { get; set; }

    public DbSet<Locacao> Locacoes{ get; set; }

    public DbSet<Ligacao> Ligagoes{ get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        optionsBuilder.UseSqlite("Data source=App.db");
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder){

        modelBuilder.Entity<Livro>()
            .HasOne(l => l.Categoria)
            .WithMany(l => l.Livros)
            .HasForeignKey(l => l.CategoriaId);

        modelBuilder.Entity<Locacao>()
            .HasOne(l => l.Usuario)
            .WithMany(u => u.Locacoes)
            .HasForeignKey(l => l.UsuarioId);


        modelBuilder.Entity<Ligacao>()
                .HasKey(l => l.Id);

        modelBuilder.Entity<Ligacao>()
                .HasOne(l => l.Livro)
                .WithMany(l => l.Ligacoes)
                .HasForeignKey(l => l.LivrosId);

        modelBuilder.Entity<Ligacao>()
                .HasOne(l => l.Locacao)
                .WithMany(l => l.Ligacoes)
                .HasForeignKey(l => l.LocacoesId);

    }

}