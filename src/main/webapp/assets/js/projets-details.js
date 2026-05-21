(function initProjetDetails() {
  if (window.projetDetailsJsInitialized) {
    if (typeof window.refreshLucideIcons === 'function') {
      window.refreshLucideIcons();
    } else if (typeof lucide !== 'undefined') {
      lucide.createIcons();
    }
    return;
  }
  window.projetDetailsJsInitialized = true;

  function openModal(modal) {
    if (!modal) return;
    modal.classList.remove('is-hidden');
    modal.classList.add('is-visible');
    modal.setAttribute('aria-hidden', 'false');
  }

  function closeModal(modal) {
    if (!modal) return;
    modal.classList.remove('is-visible');
    modal.classList.add('is-hidden');
    modal.setAttribute('aria-hidden', 'true');
  }

  function openAddMemberModal() {
    openModal(document.getElementById('add-member-modal'));
  }

  function openEditProjetModal() {
    openModal(document.getElementById('edit-projet-modal'));
  }

  function openRemoveMemberModal(memberId, memberName) {
    const modal = document.getElementById('remove-member-modal');
    const idInput = document.getElementById('remove-member-id');
    const nameEl = document.getElementById('remove-member-name');
    if (idInput) idInput.value = memberId || '';
    if (nameEl) nameEl.textContent = memberName || '';
    openModal(modal);
  }

  document.addEventListener('click', function(e) {
    if (e.target.closest('#btn-edit-projet-details')) {
      e.preventDefault();
      openEditProjetModal();
      return;
    }

    if (e.target.closest('#btn-add-member') || e.target.closest('#btn-manage-team')) {
      e.preventDefault();
      openAddMemberModal();
      return;
    }

    const removeBtn = e.target.closest('.remove-member-btn');
    if (removeBtn) {
      e.preventDefault();
      openRemoveMemberModal(removeBtn.dataset.memberId, removeBtn.dataset.memberName);
      return;
    }

    if (e.target.closest('#close-edit-projet-modal') || e.target.closest('#cancel-edit-projet-modal')) {
      e.preventDefault();
      closeModal(document.getElementById('edit-projet-modal'));
      return;
    }

    if (e.target.closest('#close-add-member-modal') || e.target.closest('#cancel-add-member-modal')) {
      e.preventDefault();
      closeModal(document.getElementById('add-member-modal'));
      return;
    }

    if (e.target.closest('#close-remove-member-modal') || e.target.closest('#cancel-remove-member-modal')) {
      e.preventDefault();
      closeModal(document.getElementById('remove-member-modal'));
      return;
    }

    if (e.target.matches('.modal-overlay.is-visible')) {
      closeModal(e.target);
    }
  });
})();

if (typeof window.refreshLucideIcons === 'function') {
  window.refreshLucideIcons();
} else if (typeof lucide !== 'undefined') {
  lucide.createIcons();
}
