document.addEventListener('DOMContentLoaded', function() {
    
    // 1. Initialisation de Lucide Icons
    if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }

    // ==========================================
    // GESTION DE LA MODALE "KIT DE CONFIGURATION"
    // ==========================================
    const modal = document.getElementById('modal-env-details');
    const btnCloseModal = document.getElementById('btn-close-modal');
    
    document.addEventListener('click', function(e) {
        // Au clic sur le bouton "Oeil"
        const btnView = e.target.closest('.btn-view-env');
        
        if (btnView) {
            e.preventDefault();
            // Injection des données dans la modale
            document.getElementById('modal-front-url').textContent = btnView.getAttribute('data-front') || 'Non défini';
            document.getElementById('modal-back-url').textContent = btnView.getAttribute('data-back') || 'Non défini';
            document.getElementById('modal-db-name').textContent = btnView.getAttribute('data-db') || 'Non défini';
            document.getElementById('modal-notes').textContent = btnView.getAttribute('data-notes') || 'Aucune note technique disponible.';
            
            // Affichage de la modale via l'ajout de la classe 'is-visible'
            modal.classList.add('is-visible');
        }

        // Fermeture de la modale (Clic sur X ou à l'extérieur)
        if (e.target.closest('#btn-close-modal') || e.target === modal) {
            modal.classList.remove('is-visible');
        }
    });

    // ==========================================
    // COPIE DANS LE PRESSE-PAPIER
    // ==========================================
    document.querySelectorAll('.btn-copy').forEach(btn => {
        btn.addEventListener('click', function() {
            const textToCopy = this.previousElementSibling.textContent;
            if (textToCopy && textToCopy !== 'Non défini') {
                navigator.clipboard.writeText(textToCopy).then(() => {
                    const originalHTML = this.innerHTML;
                    this.innerHTML = '<i data-lucide="check" style="color: #10b981;"></i>';
                    lucide.createIcons();
                    setTimeout(() => { 
                        this.innerHTML = originalHTML; 
                        lucide.createIcons(); 
                    }, 2000);
                });
            }
        });
    });

    // ==========================================
    // LOGIQUE DE FILTRAGE DES DONNÉES (Côté Client)
    // ==========================================
    const selectClient = document.getElementById('filter-client');
    const selectStatus = document.getElementById('filter-status');
    const selectTech = document.getElementById('filter-tech');
    const btnReset = document.getElementById('btn-reset-filters');
    const rows = document.querySelectorAll('.env-row');

    function filterTable() {
        const clientVal = selectClient ? selectClient.value : '';
        const statusVal = selectStatus ? selectStatus.value : '';
        const techVal = selectTech ? selectTech.value.toLowerCase() : '';

        rows.forEach(row => {
            const rowClient = row.getAttribute('data-client');
            const rowStatus = row.getAttribute('data-status');
            const techCellText = row.querySelector('.tech-cell').textContent.toLowerCase();
            
            let matchClient = clientVal === '' || rowClient === clientVal;
            let matchStatus = statusVal === '' || rowStatus === statusVal;
            // On vérifie si la stack technique contient le terme sélectionné
            let matchTech = techVal === '' || techCellText.includes(techVal); 
            
            if (matchClient && matchStatus && matchTech) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    }

    if (selectClient) selectClient.addEventListener('change', filterTable);
    if (selectStatus) selectStatus.addEventListener('change', filterTable);
    if (selectTech) selectTech.addEventListener('change', filterTable);

    // Bouton de réinitialisation
    if (btnReset) {
        btnReset.addEventListener('click', () => {
            if (selectClient) selectClient.value = '';
            if (selectStatus) selectStatus.value = '';
            if (selectTech) selectTech.value = '';
            filterTable();
        });
    }
});