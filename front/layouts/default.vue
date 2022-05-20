<template>
  <div class="wrapper">
    <!--<header>
      <nav> Enlaces de navegación
        <ul>
          <li>
            <a href="/lista">Lista</a>
          </li>
          <li>
            <a href="/nuevo">Nuevo</a>
          </li>
          <li>
            <a href="/lista-componente">Lista Comp.</a>
          </li>
          <li>
            <a href="/acerca-de">Acerca de</a>
          </li>
        </ul>
      </nav>
    </header>-->
      <Nuxt /><!-- Contenidos de las páginas-->
    <footer><!-- contenido del footer -->
      Laboratorio TBD
    </footer>
  </div>
</template>

<style>
html {
  font-family:
    'Source Sans Pro',
    -apple-system,
    BlinkMacSystemFont,
    'Segoe UI',
    Roboto,
    'Helvetica Neue',
    Arial,
    sans-serif;
  font-size: 16px;
  word-spacing: 1px;
  -ms-text-size-adjust: 100%;
  -webkit-text-size-adjust: 100%;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  box-sizing: border-box;
}

*,
*::before,
*::after {
  box-sizing: border-box;
  margin: 0;
}

.button--green {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #3b8070;
  color: #3b8070;
  text-decoration: none;
  padding: 10px 30px;
}

.button--green:hover {
  color: #fff;
  background-color: #3b8070;
}

.button--grey {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #35495e;
  color: #35495e;
  text-decoration: none;
  padding: 10px 30px;
  margin-left: 15px;
}

.button--grey:hover {
  color: #fff;
  background-color: #35495e;
}

footer {
  min-height: 70px;
  background-color: #191919;
  background-image: -moz-linear-gradient(top, #191919, #000000);
  background-image: -o-linear-gradient(top, #191919, #000000);
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #191919), color-stop(1, #000000));
  background-image: -webkit-linear-gradient(#191919, #000000);
  background-image: linear-gradient(top, #191919, #000000);
  filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#191919', endColorStr='#000000');
  border-top: 1px solid rgba(50, 50, 50, 0.3);
  width: 100%;
  /*position: relative;
  clear: both;             
  margin-top: 0px;            ELIMINADO
  padding-top: 0px;
  overflow: visible;*/
  position: fixed;
  bottom: 0;              /* NUEVO */
}
</style>
