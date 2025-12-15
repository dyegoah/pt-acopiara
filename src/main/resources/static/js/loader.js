// /static/js/loader.js
function carregarFragmento(idContainer, url) {
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao carregar " + url + " - status " + response.status);
            }
            return response.text();
        })
        .then(html => {
            const container = document.getElementById(idContainer);
            if (container) {
                container.innerHTML = html;
                
                // Após carregar o conteúdo, executar scripts adicionais se necessário
                if (idContainer === "footbar-container") {
                    // Atualizar ano no rodapé
                    const spanAno = document.getElementById("currentYear");
                    if (spanAno) {
                        spanAno.textContent = new Date().getFullYear();
                    }
                }
            } else {
                console.warn("Container não encontrado:", idContainer);
            }
        })
        .catch(err => {
            console.error("Falha ao carregar fragmento:", url, err);
        });
}

document.addEventListener("DOMContentLoaded", function () {
    carregarFragmento("topbar-container", "/loyaut/topbar.html");
    carregarFragmento("footbar-container", "/loyaut/footbar.html");
});


if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('/service-worker.js').then((registration) => {
    console.log('Service Worker registrado com sucesso:', registration);
  }).catch((error) => {
    console.log('Erro ao registrar o Service Worker:', error);
  });
}
