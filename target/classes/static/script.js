function mostrarSeccion(id) {
  document.querySelectorAll('.tab-content').forEach(sec => sec.classList.remove('active'));
  document.getElementById(id).classList.add('active');
}

function cargarOpciones() {
  document.getElementById('origen').innerHTML = `
    <option value="">Seleccione Origen</option>
    <option value="Zaun">Zaun</option>
    <option value="Piltover">Piltover</option>
  `;
  document.getElementById('alineacion').innerHTML = `
    <option value="">Seleccione Alineación</option>
    <option value="Defensor">Defensor</option>
    <option value="Rebelde">Rebelde</option>
    <option value="Científico">Científico</option>
    <option value="Criminal">Criminal</option>
  `;
  document.getElementById('ciudad-base').innerHTML = `
    <option value="">Seleccione Ciudad Base</option>
    <option value="Zaun">Zaun</option>
    <option value="Piltover">Piltover</option>
  `;
  document.getElementById('tipo-organizacion').innerHTML = `
    <option value="">Seleccione Tipo de Organización</option>
    <option value="Consejo">Consejo</option>
    <option value="Bandas Criminales">Bandas Criminales</option>
    <option value="Laboratorios de Investigación">Laboratorios de Investigación</option>
  `;
  document.getElementById('tipo-tecnologia').innerHTML = `
    <option value="">Seleccione Categoría</option>
    <option value="Hextech">Hextech</option>
    <option value="Shimmer">Shimmer</option>
  `;
  document.getElementById('tipo-relacion').innerHTML = `
    <option value="">Seleccione Tipo de Relación</option>
    <option value="Familiarmente">Familiarmente</option>
    <option value="Amistad">Amistad</option>
    <option value="Enemistad">Enemistad</option>
    <option value="Rivalidad">Rivalidad</option>
    <option value="Lealtad">Lealtad</option>
  `;
  document.getElementById('rol-afiliacion').innerHTML = `
    <option value="">Seleccione Rol</option>
    <option value="Líder">Líder</option>
    <option value="Agente">Agente</option>
    <option value="Espía">Espía</option>
    <option value="Inventor">Inventor</option>
  `;
}

// Llenar selects dinámicos

function llenarSelectPersonajes(id) {
  fetch('/personajes')
    .then(r => r.json())
    .then(data => {
      const select = document.getElementById(id);
      select.innerHTML = '<option value="">Seleccione un Personaje</option>';
      data.forEach(p => {
        const option = document.createElement('option');
        option.value = p.id_personaje;
        option.textContent = p.nombre;
        select.appendChild(option);
      });
    });
}

function llenarSelectOrganizaciones(id) {
  fetch('/organizaciones')
    .then(r => r.json())
    .then(data => {
      const select = document.getElementById(id);
      select.innerHTML = '<option value="">Seleccione una Organización</option>';
      data.forEach(o => {
        const option = document.createElement('option');
        option.value = o.id_organizacion;
        option.textContent = o.nombre;
        select.appendChild(option);
      });
    });
}

function llenarSelectTecnologias(id) {
  fetch('/tecnologias')
    .then(r => r.json())
    .then(data => {
      const select = document.getElementById(id);
      select.innerHTML = '<option value="">Seleccione una Tecnología</option>';
      data.forEach(t => {
        const option = document.createElement('option');
        option.value = t.id_tecnologia;
        option.textContent = t.nombre;
        select.appendChild(option);
      });
    });
}

// CRUD PERSONAJES

const formPersonaje = document.getElementById('form-personaje');
const personajeIdInput = document.getElementById('personaje-id');
const personajesContainer = document.getElementById('personajes-container');

formPersonaje.addEventListener('submit', function(e) {
  e.preventDefault();

  const personaje = {
    nombre: document.getElementById('nombre').value,
    origen: document.getElementById('origen').value,
    rol: document.getElementById('habilidades').value,
    alineacion: document.getElementById('alineacion').value
  };

  const id = personajeIdInput.value;
  const url = id ? `/personajes/${id}` : '/personajes';
  const method = id ? 'PUT' : 'POST';

  fetch(url, {
    method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(personaje)
  })
  .then(() => {
    alert(id ? 'Personaje actualizado' : 'Personaje agregado');
    formPersonaje.reset();
    personajeIdInput.value = '';
    cargarPersonajes();
    llenarSelectPersonajes('personaje-a-id');
    llenarSelectPersonajes('personaje-b-id');
    llenarSelectPersonajes('personaje-afiliacion-id');
    llenarSelectPersonajes('personaje-uso-id');
  })
  .catch(error => console.error('Error:', error));
});

function cargarPersonajes() {
  personajesContainer.innerHTML = '';
  fetch('/personajes')
    .then(r => r.json())
    .then(data => {
      data.forEach(p => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
          <h3>${p.nombre}</h3>
          <p><strong>Origen:</strong> ${p.origen}</p>
          <p><strong>Habilidades Especiales:</strong> ${p.rol}</p>
          <p><strong>Alineación:</strong> ${p.alineacion}</p>
          <button onclick="editarPersonaje(${p.id_personaje})">Editar</button>
          <button onclick="eliminarPersonaje(${p.id_personaje})">Eliminar</button>
        `;
        personajesContainer.appendChild(card);
      });
    });
}

function editarPersonaje(id) {
  fetch(`/personajes/${id}`)
    .then(r => r.json())
    .then(p => {
      personajeIdInput.value = p.id_personaje;
      document.getElementById('nombre').value = p.nombre;
      document.getElementById('origen').value = p.origen;
      document.getElementById('habilidades').value = p.rol;
      document.getElementById('alineacion').value = p.alineacion;
    });
}

function eliminarPersonaje(id) {
  if (confirm('¿Estás seguro de eliminar este personaje?')) {
    fetch(`/personajes/${id}`, { method: 'DELETE' })
      .then(() => {
        alert('Personaje eliminado');
        cargarPersonajes();
        llenarSelectPersonajes('personaje-a-id');
        llenarSelectPersonajes('personaje-b-id');
        llenarSelectPersonajes('personaje-afiliacion-id');
        llenarSelectPersonajes('personaje-uso-id');
      });
  }
}

// CRUD ORGANIZACIONES
const formOrganizacion = document.getElementById('form-organizacion');
const organizacionIdInput = document.getElementById('organizacion-id');
const organizacionesContainer = document.getElementById('organizaciones-container');

formOrganizacion.addEventListener('submit', function(e) {
  e.preventDefault();

  const organizacion = {
    nombre: document.getElementById('nombre-organizacion').value,
    ciudad_base: document.getElementById('ciudad-base').value,
    tipo: document.getElementById('tipo-organizacion').value
  };

  const id = organizacionIdInput.value;
  const url = id ? `/organizaciones/${id}` : '/organizaciones';
  const method = id ? 'PUT' : 'POST';

  fetch(url, {
    method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(organizacion)
  })
  .then(() => {
    alert(id ? 'Organización actualizada' : 'Organización agregada');
    formOrganizacion.reset();
    organizacionIdInput.value = '';
    cargarOrganizaciones();
    llenarSelectOrganizaciones('organizacion-afiliacion-id');
  })
  .catch(error => console.error('Error:', error));
});

function cargarOrganizaciones() {
  organizacionesContainer.innerHTML = '';
  fetch('/organizaciones')
    .then(r => r.json())
    .then(data => {
      data.forEach(o => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
          <h3>${o.nombre}</h3>
          <p><strong>Ciudad Base:</strong> ${o.ciudad_base}</p>
          <p><strong>Tipo:</strong> ${o.tipo}</p>
          <button onclick="editarOrganizacion(${o.id_organizacion})">Editar</button>
          <button onclick="eliminarOrganizacion(${o.id_organizacion})">Eliminar</button>
        `;
        organizacionesContainer.appendChild(card);
      });
    });
}

function editarOrganizacion(id) {
  fetch(`/organizaciones/${id}`)
    .then(r => r.json())
    .then(o => {
      organizacionIdInput.value = o.id_organizacion;
      document.getElementById('nombre-organizacion').value = o.nombre;
      document.getElementById('ciudad-base').value = o.ciudad_base;
      document.getElementById('tipo-organizacion').value = o.tipo;
    });
}

function eliminarOrganizacion(id) {
  if (confirm('¿Estás seguro de eliminar esta organización?')) {
    fetch(`/organizaciones/${id}`, { method: 'DELETE' })
      .then(() => {
        alert('Organización eliminada');
        cargarOrganizaciones();
        llenarSelectOrganizaciones('organizacion-afiliacion-id');
      });
  }
}

// CRUD TECNOLOGIAS
const formTecnologia = document.getElementById('form-tecnologia');
const tecnologiaIdInput = document.getElementById('tecnologia-id');
const tecnologiasContainer = document.getElementById('tecnologias-container');

formTecnologia.addEventListener('submit', function(e) {
  e.preventDefault();

  const tecnologia = {
    nombre: document.getElementById('nombre-tecnologia').value,
    tipo: document.getElementById('tipo-tecnologia').value,
    descripcion: document.getElementById('descripcion-tecnologia').value
  };

  const id = tecnologiaIdInput.value;
  const url = id ? `/tecnologias/${id}` : '/tecnologias';
  const method = id ? 'PUT' : 'POST';

  fetch(url, {
    method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(tecnologia)
  })
  .then(() => {
    alert(id ? 'Tecnología actualizada' : 'Tecnología agregada');
    formTecnologia.reset();
    tecnologiaIdInput.value = '';
    cargarTecnologias();
    llenarSelectTecnologias('tecnologia-uso-id');
  })
  .catch(error => console.error('Error:', error));
});

function cargarTecnologias() {
  tecnologiasContainer.innerHTML = '';
  fetch('/tecnologias')
    .then(r => r.json())
    .then(data => {
      data.forEach(t => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
          <h3>${t.nombre}</h3>
          <p><strong>Categoría:</strong> ${t.tipo}</p>
          <p><strong>Función:</strong> ${t.descripcion}</p>
          <button onclick="editarTecnologia(${t.id_tecnologia})">Editar</button>
          <button onclick="eliminarTecnologia(${t.id_tecnologia})">Eliminar</button>
        `;
        tecnologiasContainer.appendChild(card);
      });
    });
}

function editarTecnologia(id) {
  fetch(`/tecnologias/${id}`)
    .then(r => r.json())
    .then(t => {
      tecnologiaIdInput.value = t.id_tecnologia;
      document.getElementById('nombre-tecnologia').value = t.nombre;
      document.getElementById('tipo-tecnologia').value = t.tipo;
      document.getElementById('descripcion-tecnologia').value = t.descripcion;
    });
}

function eliminarTecnologia(id) {
  if (confirm('¿Estás seguro de eliminar esta tecnología?')) {
    fetch(`/tecnologias/${id}`, { method: 'DELETE' })
      .then(() => {
        alert('Tecnología eliminada');
        cargarTecnologias();
        llenarSelectTecnologias('tecnologia-uso-id');
      });
  }
}

// CRUD RELACIONES
const formRelacion = document.getElementById('form-relacion');
const relacionIdInput = document.getElementById('relacion-id');
const relacionesContainer = document.getElementById('relaciones-container');

formRelacion.addEventListener('submit', function(e) {
  e.preventDefault();

  const relacion = {
    id_personaje_a: document.getElementById('personaje-a-id').value,
    id_personaje_b: document.getElementById('personaje-b-id').value,
    tipo_relacion: document.getElementById('tipo-relacion').value
  };

  const id = relacionIdInput.value;
  const url = id ? `/relaciones/${id}` : '/relaciones';
  const method = id ? 'PUT' : 'POST';

  fetch(url, {
    method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(relacion)
  })
  .then(() => {
    alert(id ? 'Relación actualizada' : 'Relación agregada');
    formRelacion.reset();
    relacionIdInput.value = '';
    cargarRelaciones();
  })
  .catch(error => console.error('Error:', error));
});

function cargarRelaciones() {
  relacionesContainer.innerHTML = '';
  Promise.all([
    fetch('/relaciones').then(r => r.json()),
    fetch('/personajes').then(r => r.json())
  ]).then(([relaciones, personajes]) => {
    const mapaPersonajes = {};
    personajes.forEach(p => mapaPersonajes[p.id_personaje] = p.nombre);

    relaciones.forEach(rel => {
      const card = document.createElement('div');
      card.className = 'card';
      card.innerHTML = `
        <p><strong>${mapaPersonajes[rel.id_personaje_a]}</strong> tiene relación de <strong>${rel.tipo_relacion}</strong> con <strong>${mapaPersonajes[rel.id_personaje_b]}</strong></p>
        <button onclick="editarRelacion(${rel.id_relacion})">Editar</button>
        <button onclick="eliminarRelacion(${rel.id_relacion})">Eliminar</button>
      `;
      relacionesContainer.appendChild(card);
    });
  });
}

function editarRelacion(id) {
  fetch(`/relaciones/${id}`)
    .then(r => r.json())
    .then(rel => {
      relacionIdInput.value = rel.id_relacion;
      document.getElementById('personaje-a-id').value = rel.id_personaje_a;
      document.getElementById('personaje-b-id').value = rel.id_personaje_b;
      document.getElementById('tipo-relacion').value = rel.tipo_relacion;
    });
}

function eliminarRelacion(id) {
  if (confirm('¿Estás seguro de eliminar esta relación?')) {
    fetch(`/relaciones/${id}`, { method: 'DELETE' })
      .then(() => {
        alert('Relación eliminada');
        cargarRelaciones();
      });
  }
}

// CRUD AFILIACIONES
const formAfiliacion = document.getElementById('form-afiliacion');
const afiliacionIdInput = document.getElementById('afiliacion-id');
const afiliacionesContainer = document.getElementById('afiliaciones-container');

formAfiliacion.addEventListener('submit', function(e) {
  e.preventDefault();

  const afiliacion = {
    id_personaje: document.getElementById('personaje-afiliacion-id').value,
    id_organizacion: document.getElementById('organizacion-afiliacion-id').value,
    rol: document.getElementById('rol-afiliacion').value,
    fecha_ingreso: document.getElementById('fecha-ingreso-afiliacion').value
  };

  const id = afiliacionIdInput.value;
  const url = id ? `/afiliaciones/${id}` : '/afiliaciones';
  const method = id ? 'PUT' : 'POST';

  fetch(url, {
    method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(afiliacion)
  })
  .then(() => {
    alert(id ? 'Afiliación actualizada' : 'Afiliación agregada');
    formAfiliacion.reset();
    afiliacionIdInput.value = '';
    cargarAfiliaciones();
  })
  .catch(error => console.error('Error:', error));
});

function cargarAfiliaciones() {
  afiliacionesContainer.innerHTML = '';
  Promise.all([
    fetch('/afiliaciones').then(r => r.json()),
    fetch('/personajes').then(r => r.json()),
    fetch('/organizaciones').then(r => r.json())
  ]).then(([afiliaciones, personajes, organizaciones]) => {
    const mapaPersonajes = {};
    personajes.forEach(p => mapaPersonajes[p.id_personaje] = p.nombre);

    const mapaOrganizaciones = {};
    organizaciones.forEach(o => mapaOrganizaciones[o.id_organizacion] = o.nombre);

    afiliaciones.forEach(a => {
      const card = document.createElement('div');
      card.className = 'card';
      card.innerHTML = `
        <p><strong>${mapaPersonajes[a.id_personaje]}</strong> pertenece a <strong>${mapaOrganizaciones[a.id_organizacion]}</strong> como <strong>${a.rol}</strong> desde <strong>${a.fecha_ingreso}</strong></p>
        <button onclick="editarAfiliacion(${a.id_afiliacion})">Editar</button>
        <button onclick="eliminarAfiliacion(${a.id_afiliacion})">Eliminar</button>
      `;
      afiliacionesContainer.appendChild(card);
    });
  });
}

function editarAfiliacion(id) {
  fetch(`/afiliaciones/${id}`)
    .then(r => r.json())
    .then(a => {
      afiliacionIdInput.value = a.id_afiliacion;
      document.getElementById('personaje-afiliacion-id').value = a.id_personaje;
      document.getElementById('organizacion-afiliacion-id').value = a.id_organizacion;
      document.getElementById('rol-afiliacion').value = a.rol;
      document.getElementById('fecha-ingreso-afiliacion').value = a.fecha_ingreso;
    });
}

function eliminarAfiliacion(id) {
  if (confirm('¿Estás seguro de eliminar esta afiliación?')) {
    fetch(`/afiliaciones/${id}`, { method: 'DELETE' })
      .then(() => {
        alert('Afiliación eliminada');
        cargarAfiliaciones();
      });
  }
}

// CRUD USOS TECNOLOGIA
const formUsoTecnologia = document.getElementById('form-uso-tecnologia');
const usoTecnologiaIdInput = document.getElementById('uso-tecnologia-id');
const usosTecnologiaContainer = document.getElementById('usostecnologia-container');

formUsoTecnologia.addEventListener('submit', function(e) {
  e.preventDefault();

  const uso = {
    id_personaje: document.getElementById('personaje-uso-id').value,
    id_tecnologia: document.getElementById('tecnologia-uso-id').value
  };

  const id = usoTecnologiaIdInput.value;
  const url = id ? `/usostecnologia/${id}` : '/usostecnologia';
  const method = id ? 'PUT' : 'POST';

  fetch(url, {
    method,
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(uso)
  })
  .then(() => {
    alert(id ? 'Uso de Tecnología actualizado' : 'Uso agregado');
    formUsoTecnologia.reset();
    usoTecnologiaIdInput.value = '';
    cargarUsosTecnologia();
  })
  .catch(error => console.error('Error:', error));
});

function cargarUsosTecnologia() {
  usosTecnologiaContainer.innerHTML = '';
  Promise.all([
    fetch('/usostecnologia').then(r => r.json()),
    fetch('/personajes').then(r => r.json()),
    fetch('/tecnologias').then(r => r.json())
  ]).then(([usos, personajes, tecnologias]) => {
    const mapaPersonajes = {};
    personajes.forEach(p => mapaPersonajes[p.id_personaje] = p.nombre);

    const mapaTecnologias = {};
    tecnologias.forEach(t => mapaTecnologias[t.id_tecnologia] = t.nombre);

    usos.forEach(u => {
      const card = document.createElement('div');
      card.className = 'card';
      card.innerHTML = `
        <p><strong>${mapaPersonajes[u.id_personaje]}</strong> utiliza <strong>${mapaTecnologias[u.id_tecnologia]}</strong></p>
        <button onclick="editarUsoTecnologia(${u.id_uso_tecnologia})">Editar</button>
        <button onclick="eliminarUsoTecnologia(${u.id_uso_tecnologia})">Eliminar</button>
      `;
      usosTecnologiaContainer.appendChild(card);
    });
  });
}

function editarUsoTecnologia(id) {
  fetch(`/usostecnologia/${id}`)
    .then(r => r.json())
    .then(u => {
      usoTecnologiaIdInput.value = u.id_uso_tecnologia;
      document.getElementById('personaje-uso-id').value = u.id_personaje;
      document.getElementById('tecnologia-uso-id').value = u.id_tecnologia;
    });
}

function eliminarUsoTecnologia(id) {
  if (confirm('¿Estás seguro de eliminar este uso de tecnología?')) {
    fetch(`/usostecnologia/${id}`, { method: 'DELETE' })
      .then(() => {
        alert('Uso de Tecnología eliminado');
        cargarUsosTecnologia();
      });
  }
}

// Inicializar
cargarOpciones();

llenarSelectPersonajes('personaje-a-id');
llenarSelectPersonajes('personaje-b-id');
llenarSelectPersonajes('personaje-afiliacion-id');
llenarSelectOrganizaciones('organizacion-afiliacion-id');
llenarSelectPersonajes('personaje-uso-id');
llenarSelectTecnologias('tecnologia-uso-id');

cargarPersonajes();
cargarOrganizaciones();
cargarTecnologias();
cargarRelaciones();
cargarAfiliaciones();
cargarUsosTecnologia();
