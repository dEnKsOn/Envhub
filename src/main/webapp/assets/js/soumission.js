document.addEventListener('DOMContentLoaded', function() {
    
    // 1. Initialisation des icônes Lucide
    if (typeof lucide !== 'undefined') {
        lucide.createIcons();
    }

    // 2. Gestion de l'état du formulaire lors de la soumission
    const form = document.getElementById('soumission-form');
    const btnSubmit = document.getElementById('btn-submit');
    const btnText = document.getElementById('btn-text');
    const btnIcon = document.getElementById('btn-icon');

    if (form && btnSubmit) {
        form.addEventListener('submit', function(e) {
            if (form.checkValidity()) {
                // Désactivation du bouton pour éviter les soumissions multiples
                btnSubmit.disabled = true;
                btnText.textContent = "Traitement en cours...";
                
                // Modification de l'icône
                btnIcon.setAttribute('data-lucide', 'loader-2');
                btnIcon.style.animation = 'spin 2s linear infinite';
                
                lucide.createIcons({ nameAttr: 'data-lucide' });
            }
        });
    }

    // 3. Formatage automatique du budget
    const budgetInput = document.getElementById('budgetEstime');
    if (budgetInput) {
        budgetInput.addEventListener('blur', function(e) {
            let val = parseFloat(e.target.value);
            if (!isNaN(val) && val > 0) {
                e.target.value = Math.abs(val);
            }
        });
    }

    // 4. Import de fichier texte pour le cahier des charges
    const btnImport = document.getElementById('btn-import-file');
    const fileImport = document.getElementById('file-import');
    const textareaBesoin = document.getElementById('descriptionBesoin');

    if (btnImport && fileImport && textareaBesoin) {
        
        // Simuler le clic sur l'input type file caché
        btnImport.addEventListener('click', () => {
            fileImport.click();
        });

        // Gérer le fichier sélectionné
        fileImport.addEventListener('change', function(e) {
            const file = e.target.files[0];
            if (!file) return;

            // Vérification de l'extension
            const fileName = file.name.toLowerCase();
            if (!fileName.endsWith('.txt') && !fileName.endsWith('.md')) {
                alert("Veuillez sélectionner uniquement un fichier texte (.txt ou .md)");
                e.target.value = ''; 
                return;
            }

            // Lecture du fichier
            const reader = new FileReader();
            
            reader.onload = function(event) {
                const currentContent = textareaBesoin.value;
                const newContent = event.target.result;
                
                if (currentContent.trim() !== '') {
                    textareaBesoin.value = currentContent + "\n\n--- Contenu importé depuis " + file.name + " ---\n\n" + newContent;
                } else {
                    textareaBesoin.value = newContent;
                }
                
                // Retour visuel sur le bouton
                const originalText = btnImport.innerHTML;
                btnImport.innerHTML = `<i data-lucide="check" style="color: var(--success);"></i> Import réussi`;
                lucide.createIcons();
                
                setTimeout(() => {
                    btnImport.innerHTML = originalText;
                    lucide.createIcons();
                }, 3000);
            };
            
            reader.onerror = function() {
                alert("Erreur lors de la lecture du fichier.");
            };
            
            reader.readAsText(file);
            e.target.value = ''; // Réinitialisation de l'input
        });
    }
});

// Injection dynamique du style pour le spinner d'attente
const style = document.createElement('style');
style.innerHTML = `
    @keyframes spin {
        from { transform: rotate(0deg); }
        to { transform: rotate(360deg); }
    }
`;
document.head.appendChild(style);