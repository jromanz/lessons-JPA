package com.mycompany.demo.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Musica implements Serializable {

	private static final long serialVersionUID = -2634406105022429794L;

	@EmbeddedId
	private MusicaId musicaId;
	@Column(name = "v_genero")
	private String genero;
	@Id
	@OneToOne
	@JoinColumn(name = "codigo_id")
	private CodigoUnico codigoUnico;
	@Id
	@OneToOne
	@JoinColumn(name = "artista_id")
	private Artista artista;

	public MusicaId getMusicaId() {
		return musicaId;
	}

	public void setMusicaId(MusicaId musicaId) {
		this.musicaId = musicaId;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
