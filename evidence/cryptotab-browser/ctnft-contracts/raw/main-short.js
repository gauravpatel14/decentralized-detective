document.body.classList.add(getOS())

function getOS() {
    var userAgent = navigator.userAgent || navigator.vendor || window.opera
    var userAgentLower = userAgent.toLowerCase()

    if (/ipad|iphone|ipod/.test(userAgentLower) && !window.MSStream) {
        return 'os-ios'
    }

    if (/android/.test(userAgentLower) && !window.MSStream) {
        return 'os-android'
    }

    return 'os-desktop'
}

var browserName = detectBrowser()



function detectBrowser() {
    if (navigator.userAgent.indexOf('Edge') > -1) {
        return 'edge'
    } else if ((navigator.userAgent.indexOf('Opera') != -1 || navigator.userAgent.indexOf('OPR')) != -1) {
        return 'opera'
    } else if (navigator.userAgent.indexOf('Chrome') != -1) {
        return 'chrome'
    } else if (navigator.userAgent.indexOf('Safari') != -1) {
        return 'safari'
    } else if (navigator.userAgent.indexOf('Firefox') != -1) {
        return 'firefox'
    } else if ((navigator.userAgent.indexOf('MSIE') != -1) || (!!document.documentMode == true)) {
        return 'ie'
    } else {
        return 'chrome'
    }
}


var burger = document.querySelector('.burger')
var navbar = document.querySelector('.header__navbar')
var header = document.querySelector('.header')

var headerFixing = function(e) {
    if (header == null) return

    var headerPosition = header.getBoundingClientRect().top + document.documentElement.scrollTop
   

    if (window.pageYOffset >= headerPosition + 100 && !header.classList.contains('fixed')) {
        header.classList.add('fixed')

        if (window.lottie) {
            lottie.stop('logo')
            lottie.play('logo')
        }

    }

    if (window.pageYOffset <= headerPosition + 20) {
        header.classList.remove('fixed')
    }
}

document.addEventListener('scroll', function(event) {
    headerFixing(event)
})

document.addEventListener('keydown', function(event) {
    if (event.keyCode == 27) {
        hideNavbar()
    }
})

document.addEventListener('click', function(event) {
    if (!closest(event.target, '.header__navbar') && !closest(event.target, '.burger')) {
        hideNavbar()
    }
})

burger && burger.addEventListener('click', function(event) {
    toggleNavbar()
})

function toggleNavbar() {
    if (burger.classList.contains('active')) {
        burger.classList.remove('active')
        navbar.classList.remove('active')
    } else {
        burger.classList.add('active')
        navbar.classList.add('active')
    }
}

function hideNavbar() {
    burger && burger.classList.remove('active')
    navbar && navbar.classList.remove('active')
}

function closest(el, selector) {
    var matches = el.webkitMatchesSelector ? 'webkitMatchesSelector' : (el.msMatchesSelector ? 'msMatchesSelector' : 'matches')
    while (el.parentElement) {
        if (el[matches](selector)) return el
        el = el.parentElement
    }
    return null
}

window.addEventListener('scroll', function(e) {
    if (document.body.scrollTop > 400 || document.documentElement.scrollTop > 400) {
        document.querySelector('.scroll2top') ?.classList.add('show');
    } else {
        document.querySelector('.scroll2top') ?.classList.remove('show');
    }
})

var scroll = new SmoothScroll('a[href*="#"]', {
    ignore: '.pagination a',
    updateURL: false,
    speed: 200
})

var scene = document.querySelectorAll('.parts')
var sceneElements = document.querySelectorAll('.parts__item')

const onMainPageMouseMove = () => {
    var i = 0,
    __i = 0;
    for (i = 0; i < sceneElements.length; i++) {
        if(!sceneElements[i].dataset.depth){
                sceneElements[i].dataset.depth = Math.random().toFixed(2)
        }

    }

    for (__i = 0; __i < scene.length; __i++) {
        new Parallax(scene[__i])
    }
    document.removeEventListener('mousemove', onMainPageMouseMove);
};

document.addEventListener('mousemove', onMainPageMouseMove);



if (document.getElementById('search')) {
    let searchInput = document.getElementById('search')
    let searchParent = document.querySelector('.main-card__search')
    let searchButton = document.querySelector('.btn--search')
    
    searchInput.onblur = function() {
        searchParent.classList.remove('focused')
        searchButton.classList.remove('focused')
    };
      
    searchInput.onfocus = function() {
        searchParent.classList.add('focused')
        searchButton.classList.add('focused')
    };
}