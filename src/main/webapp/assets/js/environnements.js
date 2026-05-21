(function initEnvironnementsLocal() {
  const searchInput = document.getElementById('search-input');
  const searchForm = document.getElementById('search-form');
  const tableBody = document.getElementById('environnements-table-body');

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

if (!window.environnementsJsInitialized) {
  window.environnementsJsInitialized = true;

  function openModal(modal) {
    if (modal) {
      modal.classList.remove('is-hidden');
      modal.classList.add('is-visible');
      modal.setAttribute('aria-hidden', 'false');
    }
  }

  function closeModal(modal) {
    if (modal) {
      modal.classList.remove('is-visible');
      modal.classList.add('is-hidden');
      modal.setAttribute('aria-hidden', 'true');
    }
  }

  function openEnvModal(mode, env) {
    env = env || {};
    const modal = document.getElementById('env-modal');
    const formAction = document.getElementById('env-form-action');
    const modalTitle = document.getElementById('env-modal-title');
    const modalSubtitle = document.getElementById('env-modal-subtitle');
    const modalSubmit = document.getElementById('env-modal-submit');

    if (!modal) return;

    openModal(modal);
    if (formAction) formAction.value = mode === 'edit' ? 'update' : 'create';

    const envIdInput = document.getElementById('envId');
    const projetInput = document.getElementById('projet');
    const typeInput = document.getElementById('typeEnv');
    const serveurInput = document.getElementById('serveur');
    const nomBaseInput = document.getElementById('nomBaseDeDonnees');
    const urlFrontInput = document.getElementById('urlFront');
    const urlBackInput = document.getElementById('urlBack');
    const notesInput = document.getElementById('notes');

    if (mode === 'edit') {
      if (modalTitle) modalTitle.textContent = 'Modifier l\'environnement';
      if (modalSubtitle) modalSubtitle.textContent = 'Mettez à jour les informations de cet environnement.';
      if (modalSubmit) modalSubmit.textContent = 'Mettre à jour';

      if (envIdInput) envIdInput.value = env.id || '';
      if (projetInput) projetInput.value = env.projet || '';
      if (typeInput) typeInput.value = env.type || 'DEVELOPPEMENT';
      if (serveurInput) serveurInput.value = env.serveur || '';
      if (nomBaseInput) nomBaseInput.value = env.nomBase || '';
      if (urlFrontInput) urlFrontInput.value = env.urlFront || '';
      if (urlBackInput) urlBackInput.value = env.urlBack || '';
      if (notesInput) notesInput.value = env.notes || '';
    } else {
      if (modalTitle) modalTitle.textContent = 'Ajouter un environnement';
      if (modalSubtitle) modalSubtitle.textContent = 'Renseignez les informations de l\'environnement.';
      if (modalSubmit) modalSubmit.textContent = 'Enregistrer';

      if (envIdInput) envIdInput.value = '';
      if (projetInput) projetInput.value = '';
      if (typeInput) typeInput.value = 'DEVELOPPEMENT';
      if (serveurInput) serveurInput.value = '';
      if (nomBaseInput) nomBaseInput.value = '';
      if (urlFrontInput) urlFrontInput.value = '';
      if (urlBackInput) urlBackInput.value = '';
      if (notesInput) notesInput.value = '';
    }

    if (typeof lucide !== 'undefined') lucide.createIcons();
  }

  function openDeleteModal(envId, envLabel) {
    const deleteModal = document.getElementById('delete-env-modal');
    const deleteIdInput = document.getElementById('delete-env-id');
    const deleteLabel = document.getElementById('delete-env-label');

    if (!deleteModal) return;
    if (deleteIdInput) deleteIdInput.value = envId;
    if (deleteLabel) deleteLabel.textContent = envLabel;
    openModal(deleteModal);
  }

  document.addEventListener('click', function(e) {
    const btnAdd = e.target.closest('#btn-add-env') || e.target.closest('.open-env-modal');
    if (btnAdd) {
      e.preventDefault();
      openEnvModal('create');
      return;
    }

    const btnEdit = e.target.closest('.edit-env-btn');
    if (btnEdit) {
      e.preventDefault();
      openEnvModal('edit', {
        id: btnEdit.dataset.envId,
        projet: btnEdit.dataset.projet,
        type: btnEdit.dataset.type,
        serveur: btnEdit.dataset.serveur || '',
        nomBase: btnEdit.dataset.nomBase || '',
        urlFront: btnEdit.dataset.urlFront || '',
        urlBack: btnEdit.dataset.urlBack || '',
        notes: btnEdit.dataset.notes || ''
      });
      return;
    }

    const btnDelete = e.target.closest('.delete-env-btn');
    if (btnDelete) {
      e.preventDefault();
      openDeleteModal(btnDelete.dataset.envId, btnDelete.dataset.envLabel);
      return;
    }

    if (e.target.closest('#close-env-modal') || e.target.closest('#cancel-env-modal')) {
      e.preventDefault();
      closeModal(document.getElementById('env-modal'));
      return;
    }

    if (e.target.closest('#delete-close-env-modal') || e.target.closest('#delete-env-cancel')) {
      e.preventDefault();
      closeModal(document.getElementById('delete-env-modal'));
      return;
    }

    if (e.target.matches('.modal-overlay.is-visible')) {
      closeModal(e.target);
    }
  });
}

if (typeof window.refreshLucideIcons === 'function') {
  window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
  lucide.createIcons();
}
