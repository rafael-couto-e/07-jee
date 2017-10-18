package br.edu.ifrs.canoas.jee.webapp.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifrs.canoas.jee.webapp.model.Endereco;

public class EnderecoDAO extends BaseDAO<Endereco, Long> {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<Endereco> busca(Endereco e) {

		if (e == null)
			return new ArrayList<Endereco>();

		CriteriaQuery<Endereco> query = builder().createQuery(Endereco.class);
		Root<Endereco> from = query.from(Endereco.class);

		Predicate predicate = builder().and();

		if (!StringUtils.isBlank(e.getLogradouro()))
			predicate = builder().and(predicate, builder().like(
					from.get("logradouro"), e.getLogradouro().trim().toLowerCase()));
		if (!StringUtils.isBlank(e.getCidade()))
			predicate = builder().and(predicate,
					builder().like(from.get("cidade"), e.getCidade().trim().toLowerCase()));
		if (!StringUtils.isBlank(e.getEstado()))
			predicate = builder().and(predicate,
					builder().like(from.get("estado"), e.getEstado().trim().toLowerCase()));

		return em.createQuery(query
				.select(from)
				.where(predicate)
				.orderBy(builder().asc(from.get("id"))))
				.getResultList();

	}
}
