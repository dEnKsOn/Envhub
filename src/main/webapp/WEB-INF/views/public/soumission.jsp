<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Soumettre un projet | EnvHub</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Inknut+Antiqua:wght@400;600;700&display=swap" rel="stylesheet">
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@700,500,400&display=swap" rel="stylesheet">
    
    <script src="https://unpkg.com/lucide@latest"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/soumission.css">
</head>
<body>

    <div class="split-layout">
        
        <div class="hero-panel">
            
            <img src="https://images.unsplash.com/photo-1523961131990-5ea7c61b2107?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" 
                 alt="Infrastructure EnvHub" 
                 class="hero-bg-image">
                 
            <div class="hero-overlay"></div>

            <div class="hero-content">
                <div class="brand">
                    <div class="brand-icon"><i data-lucide="blocks"></i></div>
                    <span class="brand-text">EnvHub</span>
                </div>
                
                <h1 class="hero-title">Concrétisons votre vision technologique.</h1>
                <p class="hero-subtitle">Confiez-nous votre cahier des charges. Nos ingénieurs analysent vos besoins et dimensionnent l'infrastructure parfaite pour votre projet.</p>
                
                <div class="features-list">
                    <div class="feature-item">
                        <i data-lucide="zap"></i>
                        <span>Analyse de faisabilité sous 48h</span>
                    </div>
                    <div class="feature-item">
                        <i data-lucide="shield-check"></i>
                        <span>Infrastructure sécurisée et sur-mesure</span>
                    </div>
                    <div class="feature-item">
                        <i data-lucide="server"></i>
                        <span>Déploiement haute performance</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-panel">
            <div class="form-wrapper">
                
                <div class="mobile-brand">
                    <i data-lucide="blocks"></i> EnvHub
                </div>

                <h2>Parlez-nous de votre projet</h2>
                <p class="form-intro">Remplissez ce formulaire, nous vous recontacterons très vite.</p>

                <c:if test="${not empty param.success}">
                    <div class="alert alert-success">
                        <i data-lucide="check-circle"></i>
                        <div>
                            <strong>Demande envoyée !</strong><br>
                            Un accusé de réception vous a été envoyé par e-mail. Nous vous répondons sous 48h.
                        </div>
                    </div>
                </c:if>

                <c:if test="${not empty erreur}">
                    <div class="alert alert-danger">
                        <i data-lucide="alert-circle"></i>
                        <div><c:out value="${erreur}" /></div>
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/soumission" method="post" id="soumission-form" class="card-form">
                    
                    <div class="form-grid">
                        <div class="form-group">
                            <label for="nomClient">Nom complet <span class="required">*</span></label>
                            <input type="text" id="nomClient" name="nomClient" class="form-control" placeholder="Ex: Jean Dupont" required>
                        </div>
                        <div class="form-group">
                            <label for="emailClient">Adresse Email <span class="required">*</span></label>
                            <input type="email" id="emailClient" name="emailClient" class="form-control" placeholder="jean@entreprise.com" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="entrepriseClient">Entreprise / Organisation</label>
                        <input type="text" id="entrepriseClient" name="entrepriseClient" class="form-control" placeholder="Nom de votre société (Optionnel)">
                    </div>

                    <div class="form-group">
                        <label for="titreProjet">Titre du projet <span class="required">*</span></label>
                        <input type="text" id="titreProjet" name="titreProjet" class="form-control" placeholder="Ex: Refonte du SI, Déploiement ERP..." required>
                    </div>

                    <div class="form-group">
                        <div style="display: flex; justify-content: space-between; align-items: flex-end; margin-bottom: 0.5rem;">
                            <label for="descriptionBesoin" style="margin-bottom: 0;">Cahier des charges <span class="required">*</span></label>
                            
                            <button type="button" id="btn-import-file" class="btn-import" title="Importer le contenu d'un fichier texte">
                                <i data-lucide="upload-cloud"></i> Importer .txt / .md
                            </button>
                            <input type="file" id="file-import" accept=".txt,.md" style="display: none;">
                        </div>
                        <textarea id="descriptionBesoin" name="descriptionBesoin" class="form-control" placeholder="Décrivez vos besoins, ou importez directement votre fichier texte..." required></textarea>
                    </div>

                    <div class="form-group">
                        <label for="budgetEstime">Budget estimé (DHS)</label>
                        <div class="input-with-currency">
                            <input type="number" id="budgetEstime" name="budgetEstime" class="form-control" min="0" placeholder="0.00">
                            <span class="currency-label">MAD</span>
                        </div>
                    </div>

                    <button type="submit" class="btn-submit" id="btn-submit">
                        <span id="btn-text">Soumettre le projet</span>
                        <i data-lucide="arrow-right" id="btn-icon"></i>
                    </button>
                </form>

            </div>
        </div>

    </div>

    <script src="${pageContext.request.contextPath}/assets/js/soumission.js"></script>
</body>
</html>