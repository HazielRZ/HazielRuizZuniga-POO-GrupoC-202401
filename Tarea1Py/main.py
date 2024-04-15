class Producto:
    siguiente_id = 1

    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock):
        self.id = Producto.siguiente_id
        Producto.siguiente_id += 1
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.numero_serie = numero_serie
        self.stock = stock

    def agregar_stock(self, cantidad):
        self.stock += cantidad
        print(f"{cantidad} unidades de {self.nombre} agregadas al stock. Stock total: {self.stock}")

    def eliminar_stock(self, cantidad):
        if cantidad <= self.stock:
            self.stock -= cantidad
            print(f"{cantidad} unidades de {self.nombre} eliminadas del stock. Stock total: {self.stock}")
        else:
            print(f"No hay suficientes unidades de {self.nombre} en el stock.")


class Cliente:
    siguiente_id = 1

    def __init__(self, nombre):
        self.id = Cliente.siguiente_id
        Cliente.siguiente_id += 1
        self.nombre = nombre


class Tienda:
    PASSWORD = "contraseña"

    def __init__(self):
        self.inventario = {}
        self.ventas = []
        self.clientes = []

    @staticmethod
    def verificar_password(password):
        return password == Tienda.PASSWORD

    def agregar_producto(self, producto):
        self.inventario[producto.id] = producto

    def eliminar_producto(self, id_producto):
        if any(venta.id == id_producto for venta in self.ventas):
            print("No se puede eliminar el producto porque tiene ventas asociadas.")
        else:
            del self.inventario[id_producto]
            print("Producto eliminado correctamente.")

    def agregar_cliente(self, cliente):
        self.clientes.append(cliente)

    def eliminar_cliente(self, id_cliente):
        if any(venta.id_cliente == id_cliente for venta in self.ventas):
            print("No se puede eliminar el cliente porque tiene compras asociadas.")
        else:
            self.clientes = [cliente for cliente in self.clientes if cliente.id != id_cliente]
            print("Cliente eliminado correctamente.")

    def realizar_venta(self, id_cliente, id_producto):
        cliente = next((c for c in self.clientes if c.id == id_cliente), None)
        if cliente is None:
            print("Cliente no encontrado.")
            return
        producto = self.inventario.get(id_producto)
        if producto is None:
            print("Producto no encontrado.")
            return
        print(f"El precio del producto {producto.nombre} es: ${producto.precio}")
        confirmacion = input("¿Desea realizar la compra? (S/N): ")
        if confirmacion.upper() == "S":
            self.ventas.append({"id_cliente": id_cliente, "id_producto": id_producto})
            print("Venta realizada.")
        else:
            print("Venta cancelada.")

    def mostrar_ventas(self):
        print("Ventas realizadas:")
        for venta in self.ventas:
            cliente = next((c.nombre for c in self.clientes if c.id == venta["id_cliente"]), "Cliente desconocido")
            producto = self.inventario.get(venta["id_producto"])
            producto_nombre = producto.nombre if producto else "Producto desconocido"
            print(f"Cliente: {cliente}, Producto: {producto_nombre}")

    def obtener_cantidad_productos(self):
        return len(self.inventario)

    def obtener_cantidad_clientes(self):
        return len(self.clientes)


def main():
    tienda = Tienda()

    password = input("Ingrese la contraseña: ")
    if not tienda.verificar_password(password):
        print("Contraseña incorrecta. Saliendo del programa.")
        return

    while True:
        print("\nMenú:")
        print("1. Registrar producto")
        print("2. Registrar cliente")
        print("3. Realizar venta")
        print("4. Mostrar ventas realizadas")
        print("5. Eliminar producto")
        print("6. Eliminar cliente")
        print("7. Mostrar cantidad de productos y clientes")
        print("8. Salir")
        opcion = input("Ingrese una opción: ")

        if opcion == "1":
            nombre = input("Ingrese el nombre del producto: ")
            precio = float(input("Ingrese el precio del producto: "))
            fecha_importacion = input("Ingrese la fecha de importación del producto (formato YYYY-MM-DD): ")
            numero_serie = input("Ingrese el número de serie del producto: ")
            stock = int(input("Ingrese la cantidad inicial de stock del producto: "))
            producto = Producto(nombre, precio, fecha_importacion, numero_serie, stock)
            tienda.agregar_producto(producto)
            print("Producto registrado correctamente.")
        elif opcion == "2":
            nombre_cliente = input("Ingrese el nombre del cliente: ")
            cliente = Cliente(nombre_cliente)
            tienda.agregar_cliente(cliente)
            print("Cliente registrado correctamente.")
        elif opcion == "3":
            id_cliente = int(input("Ingrese el ID del cliente: "))
            id_producto = int(input("Ingrese el ID del producto: "))
            tienda.realizar_venta(id_cliente, id_producto)
        elif opcion == "4":
            tienda.mostrar_ventas()
        elif opcion == "5":
            id_producto_eliminar = int(input("Ingrese el ID del producto a eliminar: "))
            tienda.eliminar_producto(id_producto_eliminar)
        elif opcion == "6":
            id_cliente_eliminar = int(input("Ingrese el ID del cliente a eliminar: "))
            tienda.eliminar_cliente(id_cliente_eliminar)
        elif opcion == "7":
            print("Número de productos en inventario:", tienda.obtener_cantidad_productos())
            print("Número de clientes registrados:", tienda.obtener_cantidad_clientes())
        elif opcion == "8":
            print("Saliendo del programa.")
            break
        else:
            print("Opción inválida.")


if __name__ == "__main__":
    main()
