// Definir el contenido del carrito (esto podría ser un HTML generado dinámicamente desde el servidor)
var contenidoCarrito = "<div>Contenido del carrito...</div>";

function mostrarCarrito() {
    var modal = document.createElement("div");
    modal.className = "carrito-modal";
    modal.innerHTML = contenidoCarrito;
    document.body.appendChild(modal);

    modal.addEventListener("click", function(event) {
        if (event.target === modal) {
            document.body.removeChild(modal);
        }
    });
}

function redirectToPage(role) {
    if (role === 'usuario') {
        
        window.location.href = 'usuario/index.xhtml';
    }
}

