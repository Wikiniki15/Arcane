// PERSONAJES
const formPersonaje = document.getElementById('form-personaje');
const personajeIdInput = document.getElementById('personaje-id');
const submitPersonajeButton = document.getElementById('submit-button');
const personajesContainer = document.getElementById('personajes-container');

function cargarPersonajes() {
    personajesContainer.innerHTML = '';
    fetch('/personajes')
        .then(response => response.json())
        .then(data => {
            data.forEach(personaje => {
                const card = document.createElement('div');
                card.className = 'card';
                card.innerHTML = `
                    <h3>${personaje.nombre}</h3>
                    <p><strong>Origen:</strong> ${personaje.origen}</p>
                    <p><strong>Rol:</strong> ${personaje.rol}</p>
                    <p><strong>Alineación:</strong> ${personaje.alineacion}</p>
                    <button onclick="editarPersonaje(${personaje.id_personaje})">Editar</button>
                    <button onclick="eliminarPersonaje(${personaje.id_personaje})">Eliminar</button>
                `;
                personajesContainer.appendChild(card);
            });
        });
}

formPersonaje.addEventListener('submit', function(e) {
    e.preventDefault();
    console.log("Formulario de personaje enviado");
    const personaje = {
        nombre: document.getElementById('nombre').value,
        origen: document.getElementById('origen').value,
        rol: document.getElementById('rol').value,
        alineacion: document.getElementById('alineacion').value
    };

    const id = personajeIdInput.value.trim();
    const url = id !== "" ? `/personajes/${id}` : '/personajes';
    const method = id !== "" ? 'PUT' : 'POST';

    fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(personaje)
    })
    .then(response => {
        if (!response.ok) throw new Error('Error al guardar personaje');
        return;
    })
    .then(() => {
        alert(id !== "" ? 'Personaje actualizado' : 'Personaje agregado');
        formPersonaje.reset();
        submitPersonajeButton.innerText = "Agregar Personaje";
        personajeIdInput.value = '';
        cargarPersonajes();
    })
    .catch(error => console.error('Error:', error));
});



function editarPersonaje(id) {
    fetch(`/personajes/${id}`)
        .then(response => response.json())
        .then(personaje => {
            personajeIdInput.value = personaje.id_personaje;
            document.getElementById('nombre').value = personaje.nombre;
            document.getElementById('origen').value = personaje.origen;
            document.getElementById('rol').value = personaje.rol;
            document.getElementById('alineacion').value = personaje.alineacion;
            submitPersonajeButton.innerText = "Actualizar Personaje";
        });
}

function eliminarPersonaje(id) {
    if (confirm('¿Estás seguro de eliminar este personaje?')) {
        fetch(`/personajes/${id}`, { method: 'DELETE' })
        .then(() => {
            alert('Personaje eliminado');
            cargarPersonajes();
        });
    }
}

// ORGANIZACIONES
const formOrganizacion = document.getElementById('form-organizacion');
const organizacionIdInput = document.getElementById('organizacion-id');
const organizacionesContainer = document.getElementById('organizaciones-container');
const submitOrganizacionButton = document.getElementById('submit-organizacion');

function cargarOrganizaciones() {
    organizacionesContainer.innerHTML = '';
    fetch('/organizaciones')
        .then(response => response.json())
        .then(data => {
            data.forEach(org => {
                const card = document.createElement('div');
                card.className = 'card';
                card.innerHTML = `
                    <h3>${org.nombre}</h3>
                    <p><strong>Ciudad Base:</strong> ${org.ciudad_base}</p>
                    <p><strong>Tipo:</strong> ${org.tipo}</p>
                    <button onclick="editarOrganizacion(${org.id_organizacion})">Editar</button>
                    <button onclick="eliminarOrganizacion(${org.id_organizacion})">Eliminar</button>
                `;
                organizacionesContainer.appendChild(card);
            });
        });
}

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
    .then(response => response.json())
    .then(() => {
        alert(id ? 'Organización actualizada' : 'Organización agregada');
        formOrganizacion.reset();
        submitOrganizacionButton.innerText = "Agregar Organización";
        organizacionIdInput.value = '';
        cargarOrganizaciones();
    });
});

function editarOrganizacion(id) {
    fetch(`/organizaciones/${id}`)
        .then(response => response.json())
        .then(org => {
            organizacionIdInput.value = org.id_organizacion;
            document.getElementById('nombre-organizacion').value = org.nombre;
            document.getElementById('ciudad-base').value = org.ciudad_base;
            document.getElementById('tipo-organizacion').value = org.tipo;
            submitOrganizacionButton.innerText = "Actualizar Organización";
        });
}

function eliminarOrganizacion(id) {
    if (confirm('¿Estás seguro de eliminar esta organización?')) {
        fetch(`/organizaciones/${id}`, { method: 'DELETE' })
        .then(() => {
            alert('Organización eliminada');
            cargarOrganizaciones();
        });
    }
}

// TECNOLOGÍAS
const formTecnologia = document.getElementById('form-tecnologia');
const tecnologiaIdInput = document.getElementById('tecnologia-id');
const tecnologiasContainer = document.getElementById('tecnologias-container');
const submitTecnologiaButton = document.getElementById('submit-tecnologia');

function cargarTecnologias() {
    tecnologiasContainer.innerHTML = '';
    fetch('/tecnologias')
        .then(response => response.json())
        .then(data => {
            data.forEach(tec => {
                const card = document.createElement('div');
                card.className = 'card';
                card.innerHTML = `
                    <h3>${tec.nombre}</h3>
                    <p><strong>Tipo:</strong> ${tec.tipo}</p>
                    <p>${tec.descripcion}</p>
                    <button onclick="editarTecnologia(${tec.id_tecnologia})">Editar</button>
                    <button onclick="eliminarTecnologia(${tec.id_tecnologia})">Eliminar</button>
                `;
                tecnologiasContainer.appendChild(card);
            });
        });
}

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
    .then(response => response.json())
    .then(() => {
        alert(id ? 'Tecnología actualizada' : 'Tecnología agregada');
        formTecnologia.reset();
        submitTecnologiaButton.innerText = "Agregar Tecnología";
        tecnologiaIdInput.value = '';
        cargarTecnologias();
    });
});

function editarTecnologia(id) {
    fetch(`/tecnologias/${id}`)
        .then(response => response.json())
        .then(tec => {
            tecnologiaIdInput.value = tec.id_tecnologia;
            document.getElementById('nombre-tecnologia').value = tec.nombre;
            document.getElementById('tipo-tecnologia').value = tec.tipo;
            document.getElementById('descripcion-tecnologia').value = tec.descripcion;
            submitTecnologiaButton.innerText = "Actualizar Tecnología";
        });
}

function eliminarTecnologia(id) {
    if (confirm('¿Estás seguro de eliminar esta tecnología?')) {
        fetch(`/tecnologias/${id}`, { method: 'DELETE' })
        .then(() => {
            alert('Tecnología eliminada');
            cargarTecnologias();
        });
    }
}

// RELACIONES
// AFILIACIONES
// USOS DE TECNOLOGÍA
// (continúa siguiendo el mismo patrón que hemos trabajado arriba)

cargarPersonajes();
cargarOrganizaciones();
cargarTecnologias();
cargarRelaciones();
cargarAfiliaciones();
cargarUsosTecnologia();
