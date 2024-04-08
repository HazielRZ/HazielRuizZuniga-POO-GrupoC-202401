class Empleado:
    def _init_(self, id, nombre, apellidos, fecha_nacimiento, fecha_ingreso, RFC, curp, salario, horario, rol):
        self.id = id
        self.nombre = nombre
        self.apellidos = apellidos
        self.fecha_nacimiento = fecha_nacimiento
        self.fecha_ingreso = fecha_ingreso
        self.RFC = RFC
        self.curp = curp
        self.salario = salario
        self.horario = horario
        self.rol = rol

    def _str_(self):
        return f"Empleado{{id={self.id}, nombre='{self.nombre}', apellidos='{self.apellidos}', fecha_nacimiento={self.fecha_nacimiento}, fecha_ingreso={self.fecha_ingreso}, RFC='{self.RFC}', curp='{self.curp}', salario={self.salario}, horario='{self.horario}', rol='{self.rol}'}}"

    def modificar(self, nombre, apellidos, fecha_nacimiento, fecha_ingreso, RFC, curp, salario, horario, rol):
        self.nombre = nombre
        self.apellidos = apellidos
        self.fecha_nacimiento = fecha_nacimiento
        self.fecha_ingreso = fecha_ingreso
        self.RFC = RFC
        self.curp = curp
        self.salario = salario
        self.horario = horario
        self.rol = rol


class Visitante:
    def _init_(self, id, nombre, apellidos, fecha_nacimiento, curp, numero_visitas, fecha_registro):
        self.id = id
        self.nombre = nombre
        self.apellidos = apellidos
        self.fecha_nacimiento = fecha_nacimiento
        self.curp = curp
        self.numero_visitas = numero_visitas
        self.fecha_registro = fecha_registro

    def _str_(self):
        return f"Visitante{{id={self.id}, nombre='{self.nombre}', apellidos='{self.apellidos}', fecha_nacimiento={self.fecha_nacimiento}, curp='{self.curp}', numero_visitas={self.numero_visitas}, fecha_registro='{self.fecha_registro}'}}"

    def modificar(self, nombre, apellidos, fecha_nacimiento, curp, numero_visitas, fecha_registro):
        self.nombre = nombre
        self.apellidos = apellidos
        self.fecha_nacimiento = fecha_nacimiento
        self.curp = curp
        self.numero_visitas = numero_visitas
        self.fecha_registro = fecha_registro


class Animal:
    def _init_(self, id, tipo_animal, fecha_nacimiento, peso, enfermedades, frecuencia_alimentacion, tipo_alimentacion, vacunas):
        self.id = id
        self.tipo_animal = tipo_animal
        self.fecha_nacimiento = fecha_nacimiento
        self.peso = peso
        self.enfermedades = enfermedades
        self.frecuencia_alimentacion = frecuencia_alimentacion
        self.tipo_alimentacion = tipo_alimentacion
        self.vacunas = vacunas

    def _str_(self):
        return f"Animal{{id={self.id}, tipo_animal='{self.tipo_animal}', fecha_nacimiento={self.fecha_nacimiento}, peso={self.peso}, enfermedades={self.enfermedades}, frecuencia_alimentacion='{self.frecuencia_alimentacion}', tipo_alimentacion='{self.tipo_alimentacion}', vacunas={self.vacunas}}}"

    def modificar(self, tipo_animal, fecha_nacimiento, peso, enfermedades, frecuencia_alimentacion, tipo_alimentacion, vacunas):
        self.tipo_animal = tipo_animal
        self.fecha_nacimiento = fecha_nacimiento
        self.peso = peso
        self.enfermedades = enfermedades
        self.frecuencia_alimentacion = frecuencia_alimentacion
        self.tipo_alimentacion = tipo_alimentacion
        self.vacunas = vacunas


class Mantenimiento:
    def _init_(self, empleado_encargado, id_animal, proceso_realizado, fecha_proceso, observaciones):
        self.empleado_encargado = empleado_encargado
        self.id_animal = id_animal
        self.proceso_realizado = proceso_realizado
        self.fecha_proceso = fecha_proceso
        self.observaciones = observaciones

    def _str_(self):
        return f"Mantenimiento{{empleado_encargado={self.empleado_encargado}, id_animal={self.id_animal}, proceso_realizado='{self.proceso_realizado}', fecha_proceso={self.fecha_proceso}, observaciones='{self.observaciones}'}}"


class IdGenerator:
    animal_id_counter = 0
    visitante_id_counter = 0
    empleado_id_counter = 0

    @staticmethod
    def generar_id_animal():
        IdGenerator.animal_id_counter += 1
        return IdGenerator.animal_id_counter

    @staticmethod
    def generar_id_visitante():
        IdGenerator.visitante_id_counter += 1
        return IdGenerator.visitante_id_counter

    @staticmethod
    def generar_id_empleado():
        IdGenerator.empleado_id_counter += 1
        return IdGenerator.empleado_id_counter


def mostrar_menu():
    print("\nMenú:")
    print("1. Registrar empleado")
    print("2. Registrar visitante")
    print("3. Registrar animal")
    print("4. Registrar mantenimiento")
    print("5. Consultar registros")
    print("6. Modificar registro")
    print("7. Eliminar registro")
    print("8. Salir")


def registrar_empleado():
    # Aquí puedes implementar la lógica para registrar un nuevo empleado
    pass


def registrar_visitante():
    # Aquí puedes implementar la lógica para registrar un nuevo visitante
    pass


def registrar_animal():
    # Aquí puedes implementar la lógica para registrar un nuevo animal
    pass


def registrar_mantenimiento():
    # Aquí puedes implementar la lógica para registrar un nuevo mantenimiento
    pass


def consultar_registros():
    # Aquí puedes implementar la lógica para consultar registros
    pass


def modificar_registro():
    # Aquí puedes implementar la lógica para modificar un registro
    pass


def eliminar_registro():
    # Aquí puedes implementar la lógica para eliminar un registro
    pass


# Programa principal
while True:
    mostrar_menu()
    opcion = input("Seleccione una opción: ")

    if opcion == '1':
        registrar_empleado()
    elif opcion == '2':
        registrar_visitante()
    elif opcion == '3':
        registrar_animal()
    elif opcion == '4':
        registrar_mantenimiento()
    elif opcion == '5':
        consultar_registros()
    elif opcion == '6':
        modificar_registro()
    elif opcion == '7':
        eliminar_registro()
    elif opcion == '8':
        print("hasta pronto")

        
    def registrar_empleado():
    nombre = input("nombre del empleado: ")
    apellidos = input("Apellidos del empleado: ")
    fecha_nacimiento = input("Fecha de nacimiento (dd/mm/yyyy): ")
    fecha_ingreso = input("Fecha de ingreso (dd/mm/yyyy): ")
    RFC = input("RFC del empleado: ")
    curp = input("CURP del empleado: ")
    salario = float(input("Salario del empleado: "))
    horario = input("Horario del empleado: ")
    rol = input("Rol del empleado: ")

    id_empleado = IdGenerator.generar_id_empleado()
    nuevo_empleado = Empleado(id_empleado, nombre, apellidos, fecha_nacimiento, fecha_ingreso, RFC, curp, salario, horario, rol)


def registrar_visitante():
    nombre = input("Nombre del visitante: ")
    apellidos = input("Apellidos del visitante: ")
    fecha_nacimiento = input("Fecha de nacimiento (dd/mm/yyyy): ")
    curp = input("CURP del visitante: ")
    numero_visitas = int(input("Número de visitas del visitante: "))
    fecha_registro = input("Fecha de registro (dd/mm/yyyy): ")

    id_visitante = IdGenerator.generar_id_visitante()
    nuevo_visitante = Visitante(id_visitante, nombre, apellidos, fecha_nacimiento, curp, numero_visitas, fecha_registro)
    lista_visitantes.append(nuevo_visitante)


def registrar_animal():
    tipo_animal = input("Tipo de animal: ")
    fecha_nacimiento = input("Fecha de nacimiento del animal (dd/mm/yyyy): ")
    peso = float(input("Peso del animal: "))
    enfermedades = input("Enfermedades del animal (separadas por comas, si hay varias): ").split(',')
    frecuencia_alimentacion = input("Frecuencia de alimentación del animal: ")
    tipo_alimentacion = input("Tipo de alimentación del animal: ")
    vacunas = input("¿El animal tiene vacunas? (True/False): ")

    vacunas = True if vacunas.lower() == 'true' else False

    id_animal = IdGenerator.generar_id_animal()
    nuevo_animal = Animal(id_animal, tipo_animal, fecha_nacimiento, peso, enfermedades, frecuencia_alimentacion, tipo_alimentacion, vacunas)
    lista_animales.append(nuevo_animal)


def registrar_mantenimiento():
    empleado_encargado = input("ID del empleado encargado del mantenimiento: ")
    id_animal = input("ID del animal en mantenimiento: ")
    proceso_realizado = input("Proceso realizado en el mantenimiento: ")
    fecha_proceso = input("Fecha del proceso (dd/mm/yyyy): ")
    observaciones = input("Observaciones del mantenimiento: ")

    fecha_proceso = datetime.datetime.strptime(fecha_proceso, "%d/%m/%Y")

    nuevo_mantenimiento = Mantenimiento(empleado_encargado, id_animal, proceso_realizado, fecha_proceso, observaciones)
    lista_mantenimientos.append(nuevo_mantenimiento)


def consultar_registros():
    pass


def modificar_registro():
    pass


def eliminar_registro():
    pass
def consultar_registros():
    print("Seleccione el tipo de registro a consultar:")
    print("1. Empleado")
    print("2. Visitante")
    print("3. Animal")
    print("4. Mantenimiento")
    opcion = input("Ingrese el número correspondiente: ")

    if opcion == '1':
        for empleado in lista_empleados:
            print(empleado.consultar())
    elif opcion == '2':
        for visitante in lista_visitantes:
            print(visitante.consultar())
    elif opcion == '3':
        for animal in lista_animales:
            print(animal.consultar())
    elif opcion == '4':
        for mantenimiento in lista_mantenimientos:
            print(mantenimiento.consultar())
    else:
        print("Opción no válida")


def modificar_registro():
    print("Seleccione el tipo de registro a modificar:")
    print("1. Empleado")
    print("2. Visitante")
    print("3. Animal")
    print("4. Mantenimiento")
    opcion = input("Ingrese el número correspondiente: ")

    if opcion == '1':
        id_empleado = input("Ingrese el ID del empleado a modificar: ")
    elif opcion == '2':
        id_visitante = input("Ingrese el ID del visitante a modificar: ")
    elif opcion == '3':
        id_animal = input("Ingrese el ID del animal a modificar: ")
    elif opcion == '4':
        pass
    else:
        print("Opción no válida")


def eliminar_registro():
    print("Seleccione el tipo de registro a eliminar:")
    print("1. Empleado")
    print("2. Visitante")
    print("3. Animal")
    print("4. Mantenimiento")
    opcion = input("Ingrese el número correspondiente: ")

    if opcion == '1':
        id_empleado = input("Ingrese el ID del empleado a eliminar: ")
    elif opcion == '2':
        id_visitante = input("Ingrese el ID del visitante a eliminar: ")
    elif opcion == '3':
        id_animal = input("Ingrese el ID del animal a eliminar: ")
    elif opcion == '4':
        pass
    else:
        print("Opción no válida")