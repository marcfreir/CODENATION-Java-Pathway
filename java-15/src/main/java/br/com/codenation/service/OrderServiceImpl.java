package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the price of an item
	 */
	private Double calculateItemPrice(OrderItem item) {
		Optional<Product> product = productRepository.findById(item.getProductId());
		if (product.isPresent()) {
			Double discount = product.get().getIsSale() ? 0.8 : 1.0;
			return (item.getQuantity() * product.get().getValue() * discount);
		} else {
			return 0.0;
		}
	}

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(this::calculateItemPrice).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream().map(id -> productRepository.findById(id)).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(this::calculateOrderValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return findProductsById(productIds).stream().collect(Collectors.groupingBy(Product::getIsSale));
	}

}