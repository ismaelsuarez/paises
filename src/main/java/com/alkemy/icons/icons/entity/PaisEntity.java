package com.alkemy.icons.icons.entity;

import java.util.*;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "pais")
public class PaisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String denominacion;

	@Column(name = "cant_habitantes")
	private Long cantidadHabitantes;

	private Long superficie;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "continente_id", insertable = false, updatable = false)
	private ContinenteEntity continente;

	@Column(name = "continente_id", nullable = false)
	private Long contineneteId;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "icon_pais", joinColumns = @JoinColumn(name = "pais_id"), inverseJoinColumns = @JoinColumn(name = "icon_id"))
	private Set<IconEntity> icons = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public Long getCantidadHabitantes() {
		return cantidadHabitantes;
	}

	public void setCantidadHabitantes(Long cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}

	public Long getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Long superficie) {
		this.superficie = superficie;
	}


	public ContinenteEntity getContinente() {
		return continente;
	}

	public void setContinente(ContinenteEntity continente) {
		this.continente = continente;
	}

	public Long getContineneteId() {
		return contineneteId;
	}

	public void setContineneteId(Long contineneteId) {
		this.contineneteId = contineneteId;
	}

	public Set<IconEntity> getIcons() {
		return icons;
	}

	public void setIcons(Set<IconEntity> icons) {
		this.icons = icons;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PaisEntity other = (PaisEntity) obj;
		return other.id == this.id;
	}
}
