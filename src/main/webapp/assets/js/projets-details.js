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

  // Remplir la modale pour l'environnement
  function populateViewEnvModal(btn) {
    document.getElementById('view-env-type').textContent = btn.dataset.envType;
    document.getElementById('view-env-db').textContent = btn.dataset.envDb || 'Non spécifiée';
    
    const serverSpan = document.getElementById('view-env-server');
    if (btn.dataset.envServerIp) {
        serverSpan.innerHTML = `<i data-lucide="server" style="width:14px; margin-right:4px;"></i> ${btn.dataset.envServerIp}`;
        if(btn.dataset.envServerOs) serverSpan.innerHTML += ` (${btn.dataset.envServerOs})`;
    } else {
        serverSpan.innerHTML = `<i data-lucide="laptop" style="width:14px; margin-right:4px;"></i> Poste Local / Non assigné`;
    }

    const linksContainer = document.getElementById('view-env-links');
    linksContainer.innerHTML = '';
    if (btn.dataset.envUrlFront) {
        linksContainer.innerHTML += `<a href="${btn.dataset.envUrlFront}" target="_blank" class="env-access-btn env-access-btn-front"><i data-lucide="monitor"></i> ${btn.dataset.envUrlFront}</a>`;
    }
    if (btn.dataset.envUrlBack) {
        linksContainer.innerHTML += `<a href="${btn.dataset.envUrlBack}" target="_blank" class="env-access-btn env-access-btn-back"><i data-lucide="plug"></i> ${btn.dataset.envUrlBack}</a>`;
    }
    if (!btn.dataset.envUrlFront && !btn.dataset.envUrlBack) {
        linksContainer.innerHTML = '<span class="text-muted text-sm">Aucune URL configurée.</span>';
    }

    const technoContainer = document.getElementById('view-env-technos');
    technoContainer.innerHTML = '';
    try {
        const technos = JSON.parse(btn.dataset.envTechnos || '[]');
        if (technos.length > 0) {
            technos.forEach(t => {
                const badge = document.createElement('span');
                badge.className = 'badge badge-outline';
                badge.innerHTML = `${t.nom} ${t.version && t.version !== 'null' ? '<strong>v' + t.version + '</strong>' : ''}`;
                technoContainer.appendChild(badge);
            });
        } else {
            technoContainer.innerHTML = '<span class="text-muted text-sm">Aucune technologie associée.</span>';
        }
    } catch (e) {
        technoContainer.innerHTML = '<span class="text-muted text-sm">Erreur de lecture.</span>';
    }
    
    if (typeof lucide !== 'undefined') lucide.createIcons();
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

    // Bouton de visualisation de l'environnement (Modale admin)
    const btnViewEnv = e.target.closest('.btn-view-env');
    if (btnViewEnv) {
      e.preventDefault();
      populateViewEnvModal(btnViewEnv);
      openModal(document.getElementById('view-env-modal'));
      return;
    }

    const removeBtn = e.target.closest('.remove-member-btn');
    if (removeBtn) {
      e.preventDefault();
      openRemoveMemberModal(removeBtn.dataset.memberId, removeBtn.dataset.memberName);
      return;
    }

    if (e.target.closest('.modal-close') || e.target.closest('.btn-secondary[id^="cancel-"]')) {
      e.preventDefault();
      closeModal(e.target.closest('.modal-overlay'));
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