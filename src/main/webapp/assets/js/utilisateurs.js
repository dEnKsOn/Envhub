// --- Initialisation locale (s'exécute à chaque chargement) ---
(function initUtilisateursLocal() {
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

    emailInput.addEventListener('input', function() {
      emailError.style.display = 'none';
      emailInput.style.borderColor = '';
    });
  }
})();

// Gestion des événements via délégation pour supporter le chargement AJAX
if (!window.utilisateursJsInitialized) {
  window.utilisateursJsInitialized = true;

  // --- Fonctions Modales (Corrigées) ---
  function openModal(modal) {
    if (modal) {
      modal.classList.remove('is-hidden'); // Sécurité
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

    const userIdInput = document.getElementById('userId');
    const prenomInput = document.getElementById('prenom');
    const nomInput = document.getElementById('nom');
    const emailInput = document.getElementById('email');
    const genreSelect = document.getElementById('genre');
    const profilSelect = document.getElementById('idProfil');

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
      
      if (userIdInput) userIdInput.value = user.id || '';
      if (prenomInput) prenomInput.value = user.prenom || '';
      if (nomInput) nomInput.value = user.nom || '';
      if (emailInput) emailInput.value = user.email || '';
      if (genreSelect) genreSelect.value = user.genre || '';
      
      // --- LOGIQUE UX : UN SEUL ADMIN ---
      if (profilSelect) {
        profilSelect.value = user.profilId || '';
        
        // CORRECTION : Lecture sécurisée de l'option sélectionnée
        const selectedOption = profilSelect.options[profilSelect.selectedIndex];
        const selectedText = selectedOption ? selectedOption.text.toLowerCase() : '';
        
        Array.from(profilSelect.options).forEach(opt => {
          if (selectedText && selectedText.includes('administrateur')) {
            // Verrouille l'Admin pour l'empêcher de changer son propre rôle
            opt.disabled = (opt.value !== profilSelect.value);
            profilSelect.title = "L'Administrateur ne peut pas perdre ses droits.";
          } else {
            // Empêche la promotion d'un Dev en Admin
            opt.disabled = opt.text.toLowerCase().includes('administrateur');
            profilSelect.title = "";
          }
        });
      }

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
      
      if (userIdInput) userIdInput.value = '';
      if (prenomInput) prenomInput.value = '';
      if (nomInput) nomInput.value = '';
      if (emailInput) emailInput.value = '';
      if (genreSelect) genreSelect.value = '';
      
      // --- LOGIQUE UX : UN SEUL ADMIN ---
      if (profilSelect) {
        profilSelect.value = '';
        Array.from(profilSelect.options).forEach(opt => {
          // Bloque la sélection "Administrateur" pour la création
          opt.disabled = opt.text.toLowerCase().includes('administrateur');
        });
      }
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
    const btnAdd = e.target.closest('#btn-add-user') || e.target.closest('.open-user-modal');
    if (btnAdd) {
      e.preventDefault();
      openUserModal('create');
      return;
    }

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

    const btnDelete = e.target.closest('.delete-user-btn');
    if (btnDelete) {
      e.preventDefault();
      openDeleteModal(btnDelete.dataset.userId, btnDelete.dataset.userName);
      return;
    }

    if (e.target.closest('#close-user-modal') || e.target.closest('#cancel-user-modal') || e.target.closest('#user-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('user-modal'));
      return;
    }

    if (e.target.closest('#delete-close-user-modal') || e.target.closest('#delete-user-cancel') || e.target.closest('#delete-user-modal .modal-close')) {
      e.preventDefault();
      closeModal(document.getElementById('delete-user-modal'));
      return;
    }

    if (e.target.matches('.modal-overlay')) {
      closeModal(e.target);
    }
  });
}

if (typeof window.refreshLucideIcons === 'function') {
  window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
  lucide.createIcons();
}