import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { TelaCadastroComponent } from "./components/tela-cadastro/tela-cadastro.component";
import { TelaLoginComponent } from "./components/tela-login/tela-login.component";
import { HomePageComponent } from "./home-page/home-page.component";

const routes: Routes = [
    {
        path: "",
        component: TelaLoginComponent
    },
    {
        path: "cadastro",
        component: TelaCadastroComponent
    },
    {
        path: "home",
        component: HomePageComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { useHash: true })],
    exports: [RouterModule]
})
export class AppRoutingModule { }