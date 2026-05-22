// On place la logique dans une fonction réutilisable
function runHealthChecks() {
    // On cible uniquement les pastilles qui sont encore en attente (grises)
    const indicators = document.querySelectorAll('.health-indicator.status-pending');
    
    indicators.forEach(indicator => {
        const ip = indicator.getAttribute('data-ip');
        if (!ip) return;

        // Sécurité : éviter de lancer 2 fois la requête pour la même IP
        if (indicator.dataset.fetching === 'true') return;
        indicator.dataset.fetching = 'true';

        // L'appel AJAX asynchrone
        fetch(`${CONTEXT_PATH}/api/healthcheck?ip=${encodeURIComponent(ip)}`)
            .then(response => response.json())
            .then(data => {
                indicator.classList.remove('status-pending');
                if (data.status === 'online') {
                    indicator.classList.add('status-online');
                } else {
                    indicator.classList.add('status-offline');
                }
            })
            .catch(error => {
                console.error('Erreur HealthCheck pour ' + ip, error);
                indicator.classList.remove('status-pending');
                indicator.classList.add('status-offline'); // Rouge par défaut en cas d'erreur réseau
            });
    });
}

// L'astuce infaillible pour le cycle de vie du navigateur :
if (document.readyState === 'loading') {
    // Si le DOM n'est pas encore prêt, on attend l'événement
    document.addEventListener('DOMContentLoaded', runHealthChecks);
} else {
    // Si le DOM est déjà là (clic sur le menu, retour arrière, etc.), on lance direct !
    runHealthChecks();
}