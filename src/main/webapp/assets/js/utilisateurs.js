// Gestion des événements via délégation pour supporter le chargement AJAX
if (!window.utilisateursJsInitialized) {
  window.utilisateursJsInitialized = true;

  // --- Fonctions Modales ---
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

  function openUserModal(mode = 'create', user = {}) {
    const modal = document.getElementById('user-modal');
    const userFormAction = document.getElementById('user-form-action');
    const userModalTitle = document.getElementById('user-modal-title');
    const userModalSubtitle = document.getElementById('user-modal-subtitle');
    const userModalIcon = document.getElementById('user-modal-icon');
    const userModalSubmit = document.getElementById('user-modal-submit');
    const passwordInput = document.getElementById('password');
    const passwordHelp = document.getElementById('password-help');
    
    if (!modal) return;
    
    openModal(modal);
    if (userFormAction) userFormAction.value = mode === 'edit' ? 'update' : 'create';

    if (mode === 'edit') {
      if (userModalTitle) userModalTitle.textContent = 'Modifier l\u2019utilisateur';
      if (userModalSubtitle) userModalSubtitle.textContent = 'Mettez à jour les informations de cet utilisateur.';
      if (userModalIcon) {
          userModalIcon.setAttribute('data-lucide', 'user-cog');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (userModalSubmit) userModalSubmit.textContent = 'Mettre à jour';
      if (passwordInput) { passwordInput.required = false; passwordInput.value = ''; }
      if (passwordHelp) passwordHelp.style.display = 'block';
      
      const userIdInput = document.getElementById('userId');
      const prenomInput = document.getElementById('prenom');
      const nomInput = document.getElementById('nom');
      const emailInput = document.getElementById('email');
      const genreSelect = document.getElementById('genre');
      const profilSelect = document.getElementById('idProfil');

      if (userIdInput) userIdInput.value = user.id || '';
      if (prenomInput) prenomInput.value = user.prenom || '';
      if (nomInput) nomInput.value = user.nom || '';
      if (emailInput) emailInput.value = user.email || '';
      if (genreSelect) genreSelect.value = user.genre || '';
      if (profilSelect) profilSelect.value = user.profilId || '';
    } else {
      if (userModalTitle) userModalTitle.textContent = 'Ajouter un utilisateur';
      if (userModalSubtitle) userModalSubtitle.textContent = 'Veuillez renseigner les informations de l\'utilisateur.';
      if (userModalIcon) {
          userModalIcon.setAttribute('data-lucide', 'user-plus');
          if (typeof lucide !== 'undefined') lucide.createIcons();
      }
      if (userModalSubmit) userModalSubmit.textContent = 'Enregistrer l\'utilisateur';
      if (passwordInput) { passwordInput.required = true; passwordInput.value = ''; }
      if (passwordHelp) passwordHelp.style.display = 'none';
      
      const userIdInput = document.getElementById('userId');
      const prenomInput = document.getElementById('prenom');
      const nomInput = document.getElementById('nom');
      const emailInput = document.getElementById('email');
      const genreSelect = document.getElementById('genre');
      const profilSelect = document.getElementById('idProfil');

      if (userIdInput) userIdInput.value = '';
      if (prenomInput) prenomInput.value = '';
      if (nomInput) nomInput.value = '';
      if (emailInput) emailInput.value = '';
      if (genreSelect) genreSelect.value = '';
      if (profilSelect) profilSelect.value = '';
    }
  }

  function openDeleteModal(userId, userName) {
    const deleteModal = document.getElementById('delete-user-modal');
    const deleteUserIdInput = document.getElementById('delete-user-id');
    const deleteUserName = document.getElementById('delete-user-name');
    
    if (!deleteModal) return;
    if (deleteUserIdInput) deleteUserIdInput.value = userId;
    if (deleteUserName) deleteUserName.textContent = userName;
    openModal(deleteModal);
  }

  // --- Délégation d'événements globale ---
  document.addEventListener('click', function(e) {
    // Bouton Ajouter / Open Modal
    const btnAdd = e.target.closest('#btn-add-user') || e.target.closest('.open-user-modal');
    if (btnAdd) {
      e.preventDefault();
      openUserModal('create');
      return;
    }

    // Bouton Modifier
    const btnEdit = e.target.closest('.edit-user-btn');
    if (btnEdit) {
      e.preventDefault();
      openUserModal('edit', {
        id: btnEdit.dataset.userId,
        prenom: btnEdit.dataset.prenom,
        nom: btnEdit.dataset.nom,
        email: btnEdit.dataset.email,
        genre: btnEdit.dataset.genre,
        profilId: btnEdit.dataset.profilId
      });
      return;
    }

    // Bouton Supprimer
    const btnDelete = e.target.closest('.delete-user-btn');
    if (btnDelete) {
      e.preventDefault();
      openDeleteModal(btnDelete.dataset.userId, btnDelete.dataset.userName);
      return;
    }

    // Boutons de fermeture Modale Utilisateur
    if (e.target.closest('#close-user-modal') || e.target.closest('#cancel-user-modal') || e.target.closest('#user-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('user-modal'));
      return;
    }

    // Boutons de fermeture Modale Suppression
    if (e.target.closest('#delete-close-user-modal') || e.target.closest('#delete-user-cancel') || e.target.closest('#delete-user-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('delete-user-modal'));
      return;
    }

    // Clic sur l'overlay pour fermer
    if (e.target.matches('.modal-overlay')) {
      closeModal(e.target);
    }
  });

  // --- Filtre Instantané ---
  const searchInput = document.getElementById('search-input');
  const searchForm = document.getElementById('search-form');
  const tableBody = document.getElementById('users-table-body');
  
  if (searchInput && tableBody) {
    searchInput.addEventListener('input', function(e) {
      const term = e.target.value.toLowerCase();
      const rows = tableBody.querySelectorAll('tr');
      let hasVisibleRows = false;
      
      rows.forEach(row => {
        // Ignorer la ligne de message vide ("Aucun utilisateur")
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

    // Empêcher la soumission classique du formulaire vu que la recherche est instantanée
    if (searchForm) {
      searchForm.addEventListener('submit', function(e) {
        e.preventDefault();
      });
    }
  }

  // --- Validation Formulaire (Email) ---
  const userModalForm = document.getElementById('user-modal-form');
  const emailInput = document.getElementById('email');
  const emailError = document.getElementById('email-error');

  if (userModalForm && emailInput && emailError) {
    userModalForm.addEventListener('submit', function(e) {
      const emailVal = emailInput.value.trim().toLowerCase();
      if (!emailVal.endsWith('@envhub.ma')) {
        e.preventDefault(); // Empêcher la soumission
        emailError.style.display = 'block';
        emailInput.style.borderColor = 'var(--danger)';
      }
    });

    // Cacher l'erreur dès que l'utilisateur modifie l'email
    emailInput.addEventListener('input', function() {
      emailError.style.display = 'none';
      emailInput.style.borderColor = '';
    });
  }
}

// S'assurer que les icônes sont rendues immédiatement si on vient d'injecter la page
if (typeof window.refreshLucideIcons === 'function') {
  window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
  lucide.createIcons();
}
