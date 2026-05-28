<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<div class="stack stack-lg">
  
  <div class="flex items-center justify-between gap-4 wrap">
    <div>
      <h2 class="section-title">Demandes de Projets</h2>
      <p class="text-sm text-muted mt-1">Analysez les besoins des clients et validez la faisabilité technique.</p>
    </div>
    <button type="button" class="btn btn-primary" id="btn-add-demande">
      <i data-lucide="plus-circle"></i>
      <span class="hide-mobile">Saisir une demande</span>
    </button>
  </div>

  <c:if test="${not empty param.success}">
    <div class="alert alert-success">L'opération a été enregistrée avec succès.</div>
  </c:if>
  <c:if test="${not empty erreur}">
    <div class="alert alert-danger"><c:out value="${erreur}" /></div>
  </c:if>

  <div class="card">
    <div class="table-responsive">
      <table class="data-table">
        <thead>
          <tr>
            <th>Client / Entreprise</th>
            <th>Titre du Projet</th>
            <th>Budget Estimé</th>
            <th>Statut</th>
            <th class="text-right">Actions</th>
          </tr>
        </thead>
        <tbody>
          <c:choose>
            <c:when test="${not empty listeDemandes}">
              <c:forEach items="${listeDemandes}" var="demande">
                <tr>
                  <td>
                    <div style="display: flex; flex-direction: column;">
                      <strong><c:out value="${demande.nomClient}" /></strong>
                      <span class="text-xs text-muted"><c:out value="${demande.entrepriseClient}" /></span>
                    </div>
                  </td>
                  <td>
                    <div style="display: flex; align-items: center; gap: 6px;">
                      <i data-lucide="file-text" style="width: 14px; color: var(--primary);"></i>
                      <c:out value="${demande.titreProjet}" />
                    </div>
                  </td>
                  <td>
                    <c:choose>
                      <c:when test="${not empty demande.budgetEstime}">
                        <strong><fmt:formatNumber value="${demande.budgetEstime}" type="number"/></strong> DHS
                      </c:when>
                      <c:otherwise><span class="text-muted">Non spécifié</span></c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <c:choose>
                      <c:when test="${demande.statutDemande == 'EN_ATTENTE'}">
                        <span class="badge" style="background: #fef3c7; color: #d97706;">En attente</span>
                      </c:when>
                      <c:when test="${demande.statutDemande == 'ACCEPTE'}">
                        <span class="badge" style="background: #d1fae5; color: #059669;">Accepté</span>
                      </c:when>
                      <c:otherwise>
                        <span class="badge" style="background: #fee2e2; color: #dc2626;">Rejeté</span>
                      </c:otherwise>
                    </c:choose>
                  </td>
                  <td>
                    <div class="flex items-center justify-end" style="gap: 6px;">
                      
                      <button type="button" class="btn-icon btn-icon-sm view-demande-btn" title="Voir le besoin"
                              data-id="${demande.idDemande}" data-client="${demande.nomClient}" 
                              data-email="${demande.emailClient}" data-titre="${demande.titreProjet}" 
                              data-besoin="${demande.descriptionBesoin}" data-statut="${demande.statutDemande}">
                        <i data-lucide="eye"></i>
                      </button>

                      <c:if test="${demande.statutDemande == 'EN_ATTENTE'}">
                        <button type="button" class="btn-icon btn-icon-sm accept-demande-btn" style="color: #059669;" title="Accepter le projet"
                                data-id="${demande.idDemande}" data-titre="${demande.titreProjet}">
                          <i data-lucide="check"></i>
                        </button>

                        <button type="button" class="btn-icon btn-icon-sm reject-demande-btn" style="color: #dc2626;" title="Rejeter la demande"
                                data-id="${demande.idDemande}" data-titre="${demande.titreProjet}">
                          <i data-lucide="ban"></i>
                        </button>
                      </c:if>

                      <button type="button" class="btn-icon btn-icon-sm text-red-500 delete-demande-btn" title="Supprimer"
                              data-id="${demande.idDemande}">
                        <i data-lucide="trash-2"></i>
                      </button>

                    </div>
                  </td>
                </tr>
              </c:forEach>
            </c:when>
            <c:otherwise>
              <tr>
                <td colspan="5" class="text-center text-muted" style="padding: 3rem;">
                  <i data-lucide="folder-open" style="width: 48px; height: 48px; opacity: 0.2; margin: 0 auto 1rem;"></i>
                  <p>Aucune demande de projet reçue pour le moment.</p>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </tbody>
      </table>
    </div>
  </div>
</div>

<div id="add-demande-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Saisir une demande de projet</h2>
      <button type="button" class="modal-close" id="close-add-modal"><i data-lucide="x"></i></button>
    </header>
    <form action="${pageContext.request.contextPath}/admin/demandes" method="post">
      <input type="hidden" name="formAction" value="create">
      <div class="modal-body stack stack-sm">
        <div style="display:grid; grid-template-columns:1fr 1fr; gap:1rem;">
            <div class="form-group">
              <label>Nom du Client *</label>
              <input type="text" name="nomClient" required class="form-control" />
            </div>
            <div class="form-group">
              <label>Email du Client *</label>
              <input type="email" name="emailClient" required class="form-control" />
            </div>
        </div>
        <div class="form-group">
          <label>Entreprise / Organisation</label>
          <input type="text" name="entrepriseClient" class="form-control" />
        </div>
        <div class="form-group">
          <label>Titre du projet *</label>
          <input type="text" name="titreProjet" required class="form-control" />
        </div>
        <div class="form-group">
          <label>Cahier des charges / Description du besoin *</label>
          <textarea name="descriptionBesoin" required class="form-control" style="min-height:100px;"></textarea>
        </div>
        <div class="form-group">
          <label>Budget estimé (DHS)</label>
          <input type="number" name="budgetEstime" min="0" class="form-control" />
        </div>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-add-modal">Annuler</button>
        <button type="submit" class="btn btn-primary">Enregistrer la demande</button>
      </div>
    </form>
  </div>
</div>

<div id="view-demande-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card" style="max-width: 650px;">
    <header class="modal-header">
      <div class="modal-header-content">
        <div class="modal-header-icon"><i data-lucide="file-text"></i></div>
        <div>
          <h2 id="lbl-modal-titre">Détails de la demande</h2>
          <p class="text-xs text-muted">Soumis par <span id="lbl-modal-client" style="font-weight:bold;"></span> (<span id="lbl-modal-email"></span>)</p>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-view-modal"><i data-lucide="x"></i></button>
    </header>
    <div class="modal-body">
      <div style="background: var(--bg-color); padding: 1rem; border-radius: 6px; border: 1px solid var(--border-light); white-space: pre-wrap; max-height: 300px; overflow-y: auto;" id="lbl-modal-besoin"></div>
    </div>
    <div class="modal-actions" id="modal-view-footer">
        <button type="button" class="btn btn-secondary" id="btn-close-view-text">Fermer</button>
    </div>
  </div>
</div>

<div id="accept-demande-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <div class="modal-header-content">
        <div class="modal-header-icon" style="background-color: #d1fae5; color: #059669;"><i data-lucide="check-circle"></i></div>
        <div>
          <h2>Accepter le projet</h2>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-accept-modal"><i data-lucide="x"></i></button>
    </header>
    <form action="${pageContext.request.contextPath}/admin/demandes" method="post">
      <input type="hidden" name="formAction" value="accepter" />
      <input type="hidden" name="idDemande" id="accept-demande-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment valider le projet <strong id="accept-demande-titre"></strong> ?</p>
        <p class="text-sm text-muted mt-2">Cette action va créer un compte client, générer le projet, et envoyer un e-mail automatique d'acceptation au client.</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-accept-modal">Annuler</button>
        <button type="submit" class="btn btn-primary" style="background-color: #059669; border-color: #059669;">Valider et lancer</button>
      </div>
    </form>
  </div>
</div>

<div id="reject-demande-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <div class="modal-header-content">
        <div class="modal-header-icon" style="background-color: #fee2e2; color: #dc2626;"><i data-lucide="ban"></i></div>
        <div>
          <h2>Rejeter la demande</h2>
        </div>
      </div>
      <button type="button" class="modal-close" id="close-reject-modal"><i data-lucide="x"></i></button>
    </header>
    <form action="${pageContext.request.contextPath}/admin/demandes" method="post">
      <input type="hidden" name="formAction" value="rejeter" />
      <input type="hidden" name="idDemande" id="reject-demande-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment rejeter la demande pour <strong id="reject-demande-titre"></strong> ?</p>
        <p class="text-sm text-muted mt-2">Un e-mail de refus sera envoyé au client et le projet ne sera pas créé.</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-reject-modal">Annuler</button>
        <button type="submit" class="btn btn-danger">Confirmer le rejet</button>
      </div>
    </form>
  </div>
</div>

<div id="delete-demande-modal" class="modal-overlay is-hidden" role="dialog" aria-modal="true">
  <div class="modal-card">
    <header class="modal-header">
      <h2>Confirmer la suppression</h2>
      <button type="button" class="modal-close" id="close-delete-modal"><i data-lucide="x"></i></button>
    </header>
    <form action="${pageContext.request.contextPath}/admin/demandes" method="post">
      <input type="hidden" name="formAction" value="delete" />
      <input type="hidden" name="idDemande" id="delete-demande-id" />
      <div class="modal-body">
        <p>Voulez-vous vraiment supprimer définitivement cette demande de l'historique ?</p>
        <p class="text-sm text-muted mt-2">Cette action est irréversible.</p>
      </div>
      <div class="modal-actions">
        <button type="button" class="btn btn-secondary" id="cancel-delete-modal">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </form>
  </div>
</div>