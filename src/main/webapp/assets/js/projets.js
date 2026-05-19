// --- Initialisation locale (s'exécute à chaque chargement) ---
(function initProjetsLocal() {
    const searchInput = document.getElementById('search-input');
    const searchForm = document.getElementById('search-form');
    const tableBody = document.getElementById('projets-table-body');
    
    if (searchInput && tableBody) {
      searchInput.addEventListener('input', function(e) {
        const term = e.target.value.toLowerCase();
        const rows = tableBody.querySelectorAll('tr');
        let hasVisibleRows = false;
        
        rows.forEach(row => {
          if (row.cells.length > 1) {
            const text = row.textContent.toLowerCase();
            if (text.includes(term)) {
              row.style.display = '';
              hasVisibleRows = true;
            } else {
              row.style.display = 'none';
            }
          }
        });
  
        const noResultsMessage = document.getElementById('no-results-message');
        const noResultsQuery = document.getElementById('no-results-query');
        if (noResultsMessage && noResultsQuery) {
          if (!hasVisibleRows && term.trim() !== '') {
            noResultsQuery.textContent = e.target.value;
            noResultsMessage.style.display = 'flex';
          } else {
            noResultsMessage.style.display = 'none';
          }
        }
      });
  
      if (searchForm) {
        searchForm.addEventListener('submit', function(e) {
          e.preventDefault();
        });
      }
    }
  })();
  
  // Gestion des événements via délégation pour supporter le chargement AJAX
  if (!window.projetsJsInitialized) {
    window.projetsJsInitialized = true;
  
    function openModal(modal) {
      if (modal) {
        modal.classList.add('is-visible');
        modal.setAttribute('aria-hidden', 'false');
      }
    }
  
    function closeModal(modal) {
      if (modal) {
        modal.classList.remove('is-visible');
        modal.setAttribute('aria-hidden', 'true');
      }
    }
  
    function openProjetModal(mode = 'create', projet = {}) {
      const modal = document.getElementById('projet-modal');
      const formAction = document.getElementById('projet-form-action');
      const modalTitle = document.getElementById('projet-modal-title');
      const modalSubtitle = document.getElementById('projet-modal-subtitle');
      const modalIcon = document.getElementById('projet-modal-icon');
      const modalSubmit = document.getElementById('projet-modal-submit');
      
      if (!modal) return;
      
      openModal(modal);
      if (formAction) formAction.value = mode === 'edit' ? 'update' : 'create';
  
      const projetIdInput = document.getElementById('projetId');
      const nomInput = document.getElementById('nom');
      const clientInput = document.getElementById('client');
      const statutInput = document.getElementById('statut');
      const avancementInput = document.getElementById('avancement');
      const dateLancementInput = document.getElementById('dateLancement');
      const dateLivraisonInput = document.getElementById('dateLivraison');
      const descriptionInput = document.getElementById('description');

      const statusProgressGroup = document.getElementById('status-progress-group');
      const dateLancementGroup = document.getElementById('date-lancement-group');
  
      if (mode === 'edit') {
        if (modalTitle) modalTitle.textContent = 'Modifier le projet';
        if (modalSubtitle) modalSubtitle.textContent = 'Mettez à jour les informations de ce projet.';
        if (modalIcon) {
            modalIcon.setAttribute('data-lucide', 'folder');
            if (typeof lucide !== 'undefined') lucide.createIcons();
        }
        if (modalSubmit) modalSubmit.textContent = 'Mettre à jour';
        
        if (statusProgressGroup) statusProgressGroup.style.display = 'grid';
        if (dateLancementGroup) dateLancementGroup.style.display = 'block';

        if (projetIdInput) projetIdInput.value = projet.id || '';
        if (nomInput) nomInput.value = projet.nom || '';
        if (clientInput) clientInput.value = projet.client || '';
        if (statutInput) statutInput.value = projet.statut || 'EN_COURS';
        if (avancementInput) avancementInput.value = projet.avancement || '0';
        if (dateLancementInput) dateLancementInput.value = projet.dateLancement || '';
        if (dateLivraisonInput) dateLivraisonInput.value = projet.dateLivraison || '';
        if (descriptionInput) descriptionInput.value = projet.description || '';
      } else {
        if (modalTitle) modalTitle.textContent = 'Ajouter un projet';
        if (modalSubtitle) modalSubtitle.textContent = 'Veuillez renseigner les informations du projet.';
        if (modalIcon) {
            modalIcon.setAttribute('data-lucide', 'folder');
            if (typeof lucide !== 'undefined') lucide.createIcons();
        }
        if (modalSubmit) modalSubmit.textContent = 'Enregistrer le projet';
        
        if (statusProgressGroup) statusProgressGroup.style.display = 'none';
        if (dateLancementGroup) dateLancementGroup.style.display = 'none';

        if (projetIdInput) projetIdInput.value = '';
        if (nomInput) nomInput.value = '';
        if (clientInput) clientInput.value = '';
        if (statutInput) statutInput.value = 'EN_COURS';
        if (avancementInput) avancementInput.value = '0';
        if (dateLancementInput) dateLancementInput.value = '';
        if (dateLivraisonInput) dateLivraisonInput.value = '';
        if (descriptionInput) descriptionInput.value = '';
      }
    }
  
    function openDeleteModal(projetId, projetName) {
      const deleteModal = document.getElementById('delete-projet-modal');
      const deleteIdInput = document.getElementById('delete-projet-id');
      const deleteName = document.getElementById('delete-projet-name');
      
      if (!deleteModal) return;
      if (deleteIdInput) deleteIdInput.value = projetId;
      if (deleteName) deleteName.textContent = projetName;
      openModal(deleteModal);
    }
  
    document.addEventListener('click', function(e) {
      const btnAdd = e.target.closest('#btn-add-projet') || e.target.closest('.open-projet-modal');
      if (btnAdd) {
        e.preventDefault();
        openProjetModal('create');
        return;
      }
  
      const btnEdit = e.target.closest('.edit-projet-btn');
      if (btnEdit) {
        e.preventDefault();
        openProjetModal('edit', {
          id: btnEdit.dataset.projetId,
          nom: btnEdit.dataset.nom,
          client: btnEdit.dataset.client,
          statut: btnEdit.dataset.statut,
          avancement: btnEdit.dataset.avancement,
          dateLancement: btnEdit.dataset.dateLancement,
          dateLivraison: btnEdit.dataset.dateLivraison,
          description: btnEdit.dataset.description
        });
        return;
      }
  
      const btnDelete = e.target.closest('.delete-projet-btn');
      if (btnDelete) {
        e.preventDefault();
        openDeleteModal(btnDelete.dataset.projetId, btnDelete.dataset.projetName);
        return;
      }
  
      if (e.target.closest('#close-projet-modal') || e.target.closest('#cancel-projet-modal') || e.target.closest('#projet-modal .modal-close')) {
        e.preventDefault();
        closeModal(document.getElementById('projet-modal'));
        return;
      }
  
      if (e.target.closest('#delete-close-projet-modal') || e.target.closest('#delete-projet-cancel') || e.target.closest('#delete-projet-modal .modal-close')) {
        e.preventDefault();
        closeModal(document.getElementById('delete-projet-modal'));
        return;
      }
  
      if (e.target.matches('.modal-overlay')) {
        closeModal(e.target);
      }
    });
  }
  
  // Rafraîchir les icônes
  if (typeof window.refreshLucideIcons === 'function') {
    window.refreshLucideIcons();
  } else if (typeof lucide !== 'undefined') {
    lucide.createIcons();
  }