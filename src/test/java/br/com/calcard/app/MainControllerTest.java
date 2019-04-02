package br.com.calcard.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.calcard.app.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testarAprovacaoLucas() throws Exception {

		Client lucas = new Client("Lucas", "61608734234", 31, "M", 0, "solteiro", "SC", new BigDecimal("2500"));
		
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(lucas)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("entre 500 - 1000"));
	}

	@Test
	public void testarAprovacaoAna() throws Exception {
		Client ana = new Client("Ana", "52628156180", 17, "F", 0, "solteiro", "SP", new BigDecimal("1000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(ana)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("entre 100 - 500"));
	}

	@Test
	public void testarAprovacaoPedro() throws Exception {
		Client pedro = new Client("Pedro", "33353114858", 68, "M", 3, "casado", "SC", new BigDecimal("8000"));
		this.mockMvc
				.perform(post("/demo/add").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(pedro)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("entre 1500 - 2000"));
	}

	@Test
	public void testarAprovacaoPaula() throws Exception {
		Client paula = new Client("Paula", "36674753653", 61, "F", 3, "casado", "RJ", new BigDecimal("5000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(paula)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("entre 1000 - 1500"));
	}

	@Test
	public void testarAprovacaoJoao() throws Exception {

		Client joao = new Client("João", "16786737307", 56, "M", 2, "divorciado", "RJ", new BigDecimal("2000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(joao)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Negado"))
				.andExpect(jsonPath("$.creditLimit").value("reprovado pela política de crédito"));

	}

	@Test
	public void testarAprovacaoMaria() throws Exception {

		Client maria = new Client("Maria", "49356440956", 45, "F", 1, "divorciado", "SP", new BigDecimal("2000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(maria)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Negado"))
				.andExpect(jsonPath("$.creditLimit").value("reprovado pela política de crédito"));

	}

	@Test
	public void testarAprovacaoJose() throws Exception {
		Client jose = new Client("José", "32485467781", 30, "M", 2, "casado", "MA", new BigDecimal("8000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(jose)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("superior 2000"));

	}

	@Test
	public void testarAprovacaoDinae() throws Exception {

		Client dinae = new Client("Dinae", "18026326547", 33, "F", 1, "casado", "SP", new BigDecimal("10000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(dinae)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("superior 2000"));

	}

	@Test
	public void testarAprovacaoMarcos() throws Exception {

		Client marcos = new Client("Marcos", "16333238384", 19, "M", 1, "solteiro", "SC", new BigDecimal("400"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(marcos)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Negado"))
				.andExpect(jsonPath("$.creditLimit").value("renda baixa"));

	}

	@Test
	public void testarAprovacaoSuzan() throws Exception {
		Client suzan = new Client("Suzan", "23131647485", 63, "F", 3, "viuva", "MA", new BigDecimal("1500"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(suzan)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Negado"))
				.andExpect(jsonPath("$.creditLimit").value("reprovado pela política de crédito"));

	}

	@Test
	public void testarAprovacaoLuci() throws Exception {

		Client luci = new Client("Luci", "38612585368", 28, "F", 2, "solteiro", "SC", new BigDecimal("2500"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(luci)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("entre 100 - 500"));

	}

	@Test
	public void testarAprovacaoRoberto() throws Exception {

		Client roberto = new Client("Roberto", "40975758640", 16, "M", 0, "solteiro", "SP	", new BigDecimal("500"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(roberto)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Negado"))
				.andExpect(jsonPath("$.creditLimit").value("renda baixa"));

	}

	@Test
	public void testarAprovacaoBruno() throws Exception {

		Client bruno = new Client("Bruno", "43081823790", 30, "M", 5, "casado", "MA", new BigDecimal("8000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(bruno)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("entre 1000 - 1500"));

	}

	@Test
	public void testarAprovacaoAriel() throws Exception {

		Client ariel = new Client("Ariel", "16786737307", 33, "F", 0, "viuva", "SP", new BigDecimal("10000"));
		this.mockMvc
				.perform(post("/demo/add")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(ariel)))
				.andDo(print())
				.andExpect(jsonPath("$.description").value("Aprovado"))
				.andExpect(jsonPath("$.creditLimit").value("superior 2000"));

	}

}
