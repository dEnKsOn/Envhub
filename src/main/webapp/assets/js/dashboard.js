/**
 * dashboard.js — Comportements pour EnvHub (Version MVC)
 */
(function () {
  'use strict';

  var layoutRoot = document.querySelector('.layout-root');
  var sidebarToggle = document.getElementById('sidebar-toggle');
  var mobileToggle = document.getElementById('mobile-toggle');
  var userMenuTrigger = document.getElementById('user-menu-trigger');
  var userMenuDropdown = document.getElementById('user-menu-dropdown');
  var searchInput = document.getElementById('global-search');
  var pageContainer = document.getElementById('page-container');
  var pageHeading = document.getElementById('page-heading');
  var logoutForm = document.getElementById('logout-form');
  var logoutModal = document.getElementById('logout-modal');
  var logoutConfirm = document.getElementById('logout-confirm');
  var logoutCancel = document.getElementById('logout-cancel');
  var logoutClose = document.querySelector('.modal-close');

  /** Gestion de la Sidebar (Desktop & Mobile) */
  function initSidebar() {
    [sidebarToggle, mobileToggle].forEach(btn => {
      if (!btn) return;
      btn.addEventListener('click', function () {
        layoutRoot.classList.toggle('is-sidebar-open');
      });
    });
  }

  /** Gestion du Menu Utilisateur (Dropdown) */
  function initUserMenu() {
    if (!userMenuTrigger || !userMenuDropdown) return;
    userMenuTrigger.addEventListener('click', function (e) {
      e.stopPropagation();
      userMenuDropdown.classList.toggle('is-hidden');
    });
  }

  /** Fermeture des menus au clic extérieur */
  function initClickOutside() {
    document.addEventListener('click', function () {
      if (userMenuDropdown) userMenuDropdown.classList.add('is-hidden');
    });
  }

  /** Filtre de recherche visuel (si des éléments data-search existent) */
  function initSearch() {
    if (!searchInput) return;
    searchInput.addEventListener('input', function () {
      var q = this.value.toLowerCase();
      document.querySelectorAll('[data-search]').forEach(function (el) {
        var text = el.getAttribute('data-search').toLowerCase();
        el.style.display = text.includes(q) ? '' : 'none';
      });
    });
  }
  /** Rafraîchir les icônes Lucide après modification du DOM */
  window.refreshLucideIcons = function() {
    if (typeof lucide !== 'undefined') {
      lucide.createIcons();
    }
  };
  function normalizePath(path) {
    var normalized = path.replace(/\/+$/, '');
    if (normalized === '') {
      normalized = '/dashboard';
    }
    return normalized;
  }

  function updateActiveMenu(url) {
    document.querySelectorAll('.sidebar-nav .nav-item').forEach(function (link) {
      if (!link.href) return;
      var currentPath = normalizePath(new URL(url, window.location.origin).pathname);
      var linkPath = normalizePath(new URL(link.href, window.location.origin).pathname);
      link.classList.toggle('is-active', currentPath === linkPath);
    });
  }

  function getPageHeadingFromTitle(title) {
    if (!title) return null;
    var separatorIndex = title.indexOf(' - ');
    return separatorIndex !== -1 ? title.slice(0, separatorIndex) : title;
  }

  function updatePageHeading(title) {
    if (!pageHeading || !title) return;
    var heading = getPageHeadingFromTitle(title);
    pageHeading.textContent = heading;
  }

  function setPageContent(html, title) {
    if (!pageContainer) return;
    pageContainer.innerHTML = html;
    if (title) {
      document.title = title;
      updatePageHeading(title);
    }

    // Ré-exécuter les scripts injectés via AJAX
    var scripts = pageContainer.querySelectorAll('script');
    scripts.forEach(function(oldScript) {
      var newScript = document.createElement('script');
      Array.from(oldScript.attributes).forEach(function(attr) {
        newScript.setAttribute(attr.name, attr.value);
      });
      newScript.text = oldScript.text;
      if (oldScript.parentNode) {
        oldScript.parentNode.replaceChild(newScript, oldScript);
      }
    });

    // Rafraîchir les icônes Lucide après injection
    if (typeof window.refreshLucideIcons === 'function') {
      window.refreshLucideIcons();
    }
  }

  function extractPageFragment(text) {
    var parser = new DOMParser();
    var doc = parser.parseFromString(text, 'text/html');
    var fragment = doc.querySelector('.layout-content .container');
    var title = doc.querySelector('title');
    return {
      html: fragment ? fragment.innerHTML : null,
      title: title ? title.textContent : null
    };
  }

  function loadPage(url, pushState) {
    if (!pageContainer) {
      window.location.href = url;
      return;
    }

    fetch(url, {
      headers: {
        'X-Requested-With': 'XMLHttpRequest'
      }
    })
      .then(function (response) {
        if (!response.ok) {
          throw new Error('Erreur de chargement');
        }
        return response.text();
      })
      .then(function (text) {
        var data = extractPageFragment(text);
        if (!data.html) {
          throw new Error('Contenu introuvable');
        }
        setPageContent(data.html, data.title);
        if (pushState) {
          window.history.pushState({ url: url }, '', url);
        }
        updateActiveMenu(url);
        if (layoutRoot.classList.contains('is-sidebar-open')) {
          layoutRoot.classList.remove('is-sidebar-open');
        }
      })
      .catch(function () {
        window.location.href = url;
      });
  }

  function initAjaxNavigation() {
    document.querySelectorAll('.sidebar-nav .nav-item').forEach(function (link) {
      if (!link.href) return;
      link.addEventListener('click', function (event) {
        if (event.metaKey || event.ctrlKey || event.shiftKey || event.altKey || event.button !== 0) {
          return;
        }
        event.preventDefault();
        loadPage(link.href, true);
      });
    });

    window.addEventListener('popstate', function (event) {
      var url = (event.state && event.state.url) ? event.state.url : window.location.href;
      loadPage(url, false);
    });
  }

  function openLogoutModal() {
    if (!logoutModal) return;
    logoutModal.classList.add('is-visible');
    logoutModal.setAttribute('aria-hidden', 'false');
  }

  function closeLogoutModal() {
    if (!logoutModal) return;
    logoutModal.classList.remove('is-visible');
    logoutModal.setAttribute('aria-hidden', 'true');
  }

  function initLogoutModal() {
    if (!logoutForm || !logoutModal) return;

    logoutForm.addEventListener('submit', function (event) {
      event.preventDefault();
      openLogoutModal();
    });

    if (logoutConfirm) {
      logoutConfirm.addEventListener('click', function () {
        logoutForm.submit();
      });
    }

    if (logoutCancel) {
      logoutCancel.addEventListener('click', closeLogoutModal);
    }

    if (logoutClose) {
      logoutClose.addEventListener('click', closeLogoutModal);
    }

    logoutModal.addEventListener('click', function (event) {
      if (event.target === logoutModal) {
        closeLogoutModal();
      }
    });

    document.addEventListener('keydown', function (event) {
      if (event.key === 'Escape') {
        closeLogoutModal();
      }
    });
  }

  /** Toast Notifications */
  window.showToast = function (message, type = 'info') {
    var host = document.getElementById('toast-host');
    if (!host) return;
    var toast = document.createElement('div');
    toast.className = 'toast toast-' + type;
    toast.textContent = message;
    host.appendChild(toast);
    setTimeout(() => toast.remove(), 3000);
  };

  /** Initialisation */
  function init() {
    function renderLucideIcons() {
      if (typeof lucide !== 'undefined') {
        lucide.createIcons();
      }
    }
    
    // Si Lucide est déjà chargé, l'utiliser immédiatement
    if (typeof lucide !== 'undefined') {
      renderLucideIcons();
    } else {
      // Sinon, attendre que Lucide soit chargé
      window.addEventListener('lucideReady', renderLucideIcons);
    }

    initSidebar();
    initUserMenu();
    initClickOutside();
    initSearch();
    initAjaxNavigation();
    initLogoutModal();
    updateActiveMenu(window.location.href);
    updatePageHeading(document.title);
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
})();