<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - EnvHub</title>
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inknut+Antiqua:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@400,500,700&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="https://unpkg.com/akar-icons-fonts">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css">
    <script src="${pageContext.request.contextPath}/assets/js/login.js" defer></script>
</head>
<body>
    <div class="hero-section">
        <div class="hero-content">
            <h1>Bienvenue sur EnvHub</h1>
            <p class="subtitle">Gérez vos environnements de projet en toute simplicité.</p>
            
            <form action="${pageContext.request.contextPath}/login" method="post" class="login-form">
                
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="example@entreprise.ma" required>
                </div>
                
                <div class="form-group">
                    <label for="password">Mot de passe</label>
                    <div class="password-input-container">
                        <input type="password" id="password" name="password" placeholder="••••••••" required>
                    </div>
                </div>
                
                <button type="submit" class="btn-login">Se connecter</button>
                
                <c:if test="${not empty error}">
                    <div class="error-message">
                        <c:out value="${error}" />
                    </div>
                </c:if>
                
            </form>
        </div>
    </div>
</body>
</html>