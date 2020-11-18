package com.maersk.main.bean;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("container_details")
public class ContainerDetails {
	
	@PrimaryKey
	@Column("container_id")
	private Long container_id;
	@Column("container_type")
	private String containerType;
	@Column("size")
	private Long containerSize;
	@Column("destination")
	private String destination;
	@Column("origin")
	private String origin;
	@Column("quantity")
	private Long quantity;
	
	public Long getId() {
		return container_id;
	}
	public void setId(Long id) {
		this.container_id = id;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Long getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(Long containerSize) {
		this.containerSize = containerSize;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContainerDetails [Id=");
		builder.append(container_id);
		builder.append(", containerType=");
		builder.append(containerType);
		builder.append(", containerSize=");
		builder.append(containerSize);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
}
