package com.alkemy.icons.icons.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql="UPDATE icon SET deleted = true WHERE id=?")
@Where(clause ="deleted=false")
@Table(name = "icon")
public class IconEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String denominacion;

	@Column(name = "fecha_creacion")
	@DateTimeFormat(pattern = "YYY/MM/dd")
	private LocalDate fechaCreacion;

	private Long altura;
	private String historia;

	private boolean deleted = Boolean.FALSE;

	@ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
	private List<PaisEntity> paises = new ArrayList<>();

	
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

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getAltura() {
		return altura;
	}

	public void setAltura(Long altura) {
		this.altura = altura;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<PaisEntity> getPaises() {
		return paises;
	}

	public void setPaises(List<PaisEntity> paises) {
		this.paises = paises;
	}

	public void addPais(PaisEntity pais) {
		this.paises.add(pais);
	}

	public void removePais(PaisEntity pais) {
		this.paises.remove(pais);
	}
	
	
}
