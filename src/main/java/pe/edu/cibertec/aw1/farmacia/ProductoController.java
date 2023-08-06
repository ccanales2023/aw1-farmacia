package pe.edu.cibertec.aw1.farmacia;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("productos")
public class ProductoController {

    ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    //listar
    @GetMapping
    public String list(Model modelo) {
        List<Producto> productos = productoRepository.findAll();
        modelo.addAttribute("listaProductos", productos);

        return "productos/list";
    }
    //create
    @GetMapping("create")
    public String showCreateForm(Model model) {
        ProductoDto productoDto = new ProductoDto();
        model.addAttribute("productoForm", productoDto);
        return "productos/create";
    }

    @PostMapping
    public String create(ProductoDto productoDto) {
        // Producto producto = new Producto();
        // producto.nombre = productoDto.getNombre();
        // producto.stock = productoDto.getStock();
        // producto.precio = productoDto.getPrecio();

        Producto producto = new Producto(productoDto.getNombre(), productoDto.getStock(), productoDto.getPrecio());
        productoRepository.save(producto);
        return "redirect:/productos";
    }
     @GetMapping("{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if(productoOptional.isEmpty()) {
            return "404";
        }

        Producto producto = productoOptional.get();
        model.addAttribute("producto", producto);
        return "productos/detail";
    }

    //editar
    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if(productoOptional.isEmpty()) {
            return "404";
        }

        Producto producto = productoOptional.get();
        model.addAttribute("producto", producto);
        return "productos/edit";
    }

    @PostMapping("{id}")
    public String edit(@PathVariable Long id, Producto productoDataForm) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if(productoOptional.isEmpty()) {
            return "404";
        }

        Producto producto = productoOptional.get();
        producto.nombre = productoDataForm.getNombre();
        producto.precio = productoDataForm.getPrecio();
        producto.stock = productoDataForm.getStock();
        productoRepository.save(producto);

        return "redirect:/productos";
    }
    //eliminar
    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }


}
