using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Api.Migrations
{
    /// <inheritdoc />
    public partial class capa : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Capa",
                table: "Livros");

            migrationBuilder.AddColumn<string>(
                name: "CaminhoCapa",
                table: "Livros",
                type: "TEXT",
                nullable: false,
                defaultValue: "");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "CaminhoCapa",
                table: "Livros");

            migrationBuilder.AddColumn<string>(
                name: "Capa",
                table: "Livros",
                type: "TEXT",
                nullable: true);
        }
    }
}
