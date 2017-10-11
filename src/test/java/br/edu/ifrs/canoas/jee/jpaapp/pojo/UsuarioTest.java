package br.edu.ifrs.canoas.jee.jpaapp.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class UsuarioTest {

    @Rule public WeldInitiator weld = WeldInitiator.from(Usuario.class).inject(this).build();
	@Inject 
	Usuario usuario;

	private EntityManager em;
	
	@Before
	public void setup() {
		em = EntityManagerUtil.getEM();
	}

	@Test
	public void testa_a_persistencia_do_usuario_em_branco () {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();

		assertThat(usuario.getId()).isNotNull();
	}

	

}