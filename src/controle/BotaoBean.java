package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

@ManagedBean
public class BotaoBean {

	public void sorteiaBotao(ActionEvent event) {
		UIComponent formulario = event.getComponent().getParent();

		UIComponent btJonas = formulario.findComponent("botao-jonas");
		UIComponent btMarcelo = formulario.findComponent("botao-marcelo");
		UIComponent btRafael = formulario.findComponent("botao-rafael");

		btJonas.getAttributes().put("disabled", true);
		btMarcelo.getAttributes().put("disabled", true);
		btRafael.getAttributes().put("disabled", true);

		double numero = Math.random();

		if (numero < 1.0 / 3.0) {
			btJonas.getAttributes().put("disabled", false);
			System.out.println("deu jonas");
		} else if (numero < 2.0 / 3.0) {
			btMarcelo.getAttributes().put("disabled", false);
			System.out.println("deu marcelo");
		} else {
			btRafael.getAttributes().put("disabled", false);
			System.out.println("deu rafa");
		}
	}
}
