import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CertificatesComponent } from "./components/profile/certificates/certificates.component";
import { ContentComponent } from "./components/profile/content/content.component";
import { TelaCadastroComponent } from "./components/tela-cadastro/tela-cadastro.component";
import { TelaLoginComponent } from "./components/tela-login/tela-login.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { ProfilePageComponent } from "./profile-page/profile-page.component";

const routes: Routes = [
    // {
    //     path: "",
    //     pathMatch: "full",
    //     redirectTo: "home"
    // },
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
    },
    {
        path: "profile",
        component: ProfilePageComponent,
        children: [
            {
                path: "personal",
                component: ContentComponent
            },
            {
                path: "certificates",
                component: CertificatesComponent
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { useHash: true })],
    exports: [RouterModule]
})
export class AppRoutingModule { }