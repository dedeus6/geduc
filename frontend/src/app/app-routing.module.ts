import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { TelaCadastroComponent } from "./components/tela-cadastro/tela-cadastro.component";
import { TelaLoginComponent } from "./tela-login/tela-login.component";

const routes: Routes = [
    {
        path: "",
        component: TelaLoginComponent
    },
    {
        path: "cadastro",
        component: TelaCadastroComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { useHash: true })],
    exports: [RouterModule]
})
export class AppRoutingModule { }