document.addEventListener("DOMContentLoaded", function() {
    // 1. Initialisation des icônes Lucide
    if (typeof window.refreshLucideIcons === 'function') {
        window.refreshLucideIcons();
    } else if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }

    // 2. Recherche en temps réel dans le tableau
    const searchInput = document.getElementById('search-input');
    const tableBody = document.getElementById('env-table-body');

    if (searchInput && tableBody) {
        searchInput.addEventListener('input', function(e) {
            const term = e.target.value.toLowerCase();
            const rows = tableBody.querySelectorAll('tr');

            rows.forEach(row => {
                if (row.cells.length > 1) { // Ignore la ligne "Aucun environnement"
                    const text = row.textContent.toLowerCase();
                    row.style.display = text.includes(term) ? '' : 'none';
                }
            });
        });
    }

    // 3. Fonction "Copier dans le presse-papier"
    const copyButtons = document.querySelectorAll('.btn-copy');
    copyButtons.forEach(btn => {
        btn.addEventListener('click', function(e) {
            e.preventDefault();
            const textToCopy = this.getAttribute('data-clipboard');
            
            if (navigator.clipboard && window.isSecureContext) {
                // Utilisation de l'API moderne Clipboard
                navigator.clipboard.writeText(textToCopy).then(() => {
                    visualFeedback(this);
                });
            } else {
                // Fallback (anciennes méthodes)
                let textArea = document.createElement("textarea");
                textArea.value = textToCopy;
                textArea.style.position = "fixed";
                document.body.appendChild(textArea);
                textArea.focus();
                textArea.select();
                try {
                    document.execCommand('copy');
                    visualFeedback(this);
                } catch (err) {
                    console.error('Erreur lors de la copie', err);
                }
                document.body.removeChild(textArea);
            }
        });
    });

    // Effet visuel temporaire (L'icône devient verte et se change en check)
    function visualFeedback(button) {
        const icon = button.querySelector('i');
        const originalLucide = icon.getAttribute('data-lucide');
        
        icon.setAttribute('data-lucide', 'check');
        button.classList.add('copied-success');
        
        if (typeof lucide !== 'undefined') lucide.createIcons();

        setTimeout(() => {
            icon.setAttribute('data-lucide', originalLucide);
            button.classList.remove('copied-success');
            if (typeof lucide !== 'undefined') lucide.createIcons();
        }, 1500);
    }
});