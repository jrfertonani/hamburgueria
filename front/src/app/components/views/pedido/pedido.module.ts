import { Bebida } from "../bebida/bebida.module";
import { Cliente } from "../cliente/cliente.module";
import { Lanche } from "../lanche/lanche.module";

export interface Pedido {
  id?: number;
  lanches: Lanche[];
  bebidas: Bebida[];
  cliente: Cliente;
}
