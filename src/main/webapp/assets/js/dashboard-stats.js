/**
 * dashboard-stats.js
 * Initialisation du graphique Chart.js pour le tableau de bord
 */

document.addEventListener("DOMContentLoaded", function() {
    const ctx = document.getElementById('envChart');
    
    if(ctx) {
        const statDev = parseInt(ctx.dataset.dev) || 0;
        const statStaging = parseInt(ctx.dataset.staging) || 0;
        const statProd = parseInt(ctx.dataset.prod) || 0;
        const statLocal = parseInt(ctx.dataset.local) || 0;

        const total = statDev + statStaging + statProd + statLocal;

        if (total === 0) {
            new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: ['Aucun environnement'],
                    datasets: [{ data: [1], backgroundColor: ['#E2E8F0'], borderWidth: 0 }]
                },
                options: { cutout: '75%', plugins: { legend: { display: false }, tooltip: { enabled: false } } }
            });
        } else {
            new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: ['Développement', 'Staging', 'Production', 'Local'],
                    datasets: [{
                        data: [statDev, statStaging, statProd, statLocal],
                        backgroundColor: ['#3B82F6', '#F59E0B', '#10B981', '#64748B'],
                        borderWidth: 0, hoverOffset: 4
                    }]
                },
                options: {
                    cutout: '75%', responsive: true, maintainAspectRatio: false,
                    plugins: {
                        legend: { display: false },
                        tooltip: {
                            callbacks: {
                                label: function(context) {
                                    let label = context.label || '';
                                    if (label) label += ': ';
                                    if (context.parsed !== null) label += context.parsed;
                                    return label;
                                }
                            }
                        }
                    }
                }
            });
        }
    }
});