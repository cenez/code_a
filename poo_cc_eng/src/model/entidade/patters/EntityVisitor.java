package model.entidade.patters;

import model.entidade.ItemPedido;

public interface EntityVisitor {
	boolean visit(ItemPedido visitor);
}
